package com.example.application.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.example.application.R;

import java.util.ArrayList;
import java.util.List;

public class image_car extends Activity {
    List<Uri> photo = new ArrayList<>();
Button aks_posht;
Button aks_ro;
Button edame;
int index=0;
ImageView imageView_ro;
ImageView imageView_posht;
int []aks=new int [1];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_car);

        aks_posht=findViewById(R.id.aks_posht);
        aks_ro=findViewById(R.id.aks_ro);
        edame=findViewById(R.id.edame);
imageView_ro = findViewById(R.id.imageView_ro);
imageView_posht=findViewById(R.id.imageView_posht);


//aks_ro.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View view) {
//
//    }
//});
registerForContextMenu(aks_ro);

registerForContextMenu(aks_posht);



    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_main,menu);
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.from_gallery:
                Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                index++;
                startActivityForResult(pickPhoto , 1);
                break;

            case R.id.from_camera:
                Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePicture, 0);
                index++;
                break;

            case R.id.laghv:


                break;
        }
        return super.onContextItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
//        int index=0;
        switch(requestCode) {
            case 0:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
//                    aks_ro.setVisibility(View.INVISIBLE);
//                    imageView_ro.setImageURI(selectedImage);
                    photo.add(selectedImage);
//                    index++;
                }


                break;
            case 1:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
//                    aks_ro.setVisibility(View.INVISIBLE);
//                    imageView_ro.setImageURI(selectedImage);
                    photo.add(selectedImage);
//                    index++;
                }
                break;
        }
        System.out.println(index);
        if(index ==2){
imageView_ro.setImageURI(photo.get(0));
imageView_posht.setImageURI(photo.get(1));
aks_ro.setVisibility(View.INVISIBLE);
aks_posht.setVisibility(View.INVISIBLE);

edame.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(image_car.this,last_step.class);
        startActivity(intent);
    }
});
        }


    }

}
