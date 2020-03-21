package com.example.application.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.application.R;

public class create extends AppCompatActivity {
EditText phone;
Button edame;
public static String phonenumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        phone=findViewById(R.id.phone);
        edame=findViewById(R.id.edame);
        edame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phonenumber=phone.getText().toString();
                if (phonenumber!=null) {
                    Intent intent = new Intent(create.this, accept_code.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"شماره خود را وارد کنید",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
