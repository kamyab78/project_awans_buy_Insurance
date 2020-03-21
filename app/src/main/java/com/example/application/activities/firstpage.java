package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class firstpage extends TabActivity {
    TabHost tabhost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);
        tabhost = findViewById(R.id.tabhost);
        TabHost.TabSpec spec;
        Intent intent;


        spec = tabhost.newTabSpec("خودرو");
        spec.setIndicator("خودرو " +"\n"+ "\uD83D\uDE97");
        intent = new Intent(this, khodro.class);
        spec.setContent(intent);
        tabhost.addTab(spec);


        spec = tabhost.newTabSpec("بیمه");
        spec.setIndicator("بیمه");
        intent = new Intent(this, bime.class);
        spec.setContent(intent);
        tabhost.addTab(spec);


        spec = tabhost.newTabSpec("سوابق");
        spec.setIndicator("سوابق");
        intent = new Intent(this, savabegh.class);
        spec.setContent(intent);
        tabhost.addTab(spec);


        spec = tabhost.newTabSpec("پروفایل");
        spec.setIndicator("پروفایل");
        intent = new Intent(this, profile.class);
        spec.setContent(intent);
        tabhost.addTab(spec);

        tabhost.setCurrentTab(3);
        tabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {

            }
        });
    }
}
