package com.example.application.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.application.R;

public class Slideshow extends PagerAdapter {
private Context context;
//int[]imageID={R.drawable.photo_1,R.drawable.photo_2,R.drawable.photo_3,R.drawable.photo_4,R.drawable.photo_5};
int[]imageID={R.drawable.photo_5,R.drawable.photo_4,R.drawable.photo_3,R.drawable.photo_2,R.drawable.photo_1};
private LayoutInflater layoutInflater;
public Slideshow(Context context){
this.context=context;
}

    @Override
    public int getCount() {
        return imageID.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView=new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(imageID[position]);
        container.addView(imageView,0);
        return imageView;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView)object);
}

}
