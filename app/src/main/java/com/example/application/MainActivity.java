package com.example.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.application.views.Slideshow;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;
    LinearLayout slider;
    private int dotcount;
    Button vorod;
    Button create;
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Slideshow slideshow = new Slideshow(this);
        vorod = findViewById(R.id.vorod);
        dotcount = slideshow.getCount();
        pager = findViewById(R.id.pager);
        slider = findViewById(R.id.slider);
        pager.setAdapter(slideshow);
        dots = new ImageView[dotcount];
        pager.setCurrentItem(slideshow.getCount());
        for (int i = 0; i < dotcount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            slider.addView(dots[i], params);
        }
        dots[slideshow.getCount()-1].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dotcount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        vorod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, com.example.application.activities.create.class);
                startActivity(intent);
            }
        });
    }
}
