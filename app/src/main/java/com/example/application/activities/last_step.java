package com.example.application.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.application.R;

public class last_step extends Activity {
TextView adad_aval;
TextView adad_dovom;
TextView harf;
TextView adad_sevom;
TextView model;
TextView noe;
TextView karbari;
TextView rang;
TextView silandr;
TextView shasi;
TextView motor;
TextView sal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_step);

        adad_aval=findViewById(R.id.adad_aval);
        adad_dovom=findViewById(R.id.adad_dovom);
        adad_sevom=findViewById(R.id.adad_sevom);
        harf=findViewById(R.id.harf);
        model=findViewById(R.id.model);
        noe=findViewById(R.id.noe);
        karbari=findViewById(R.id.karbari);
        rang=findViewById(R.id.rang);
        silandr=findViewById(R.id.silandr);
        shasi=findViewById(R.id.shasi);
        motor=findViewById(R.id.motor);
        sal=findViewById(R.id.sal);




        adad_aval.setText(new_car_tag.aval);
        adad_dovom.setText(new_car_tag.dovom);
        harf.setText(new_car_tag.alphabet);
        adad_sevom.setText(new_car_tag.sevom);

        model.setText(Property_car.information_car.get("model"));
        noe.setText(Property_car.information_car.get("noe"));
        karbari.setText(Property_car.information_car.get("karbari"));
        rang.setText(Property_car.information_car.get("color"));
        silandr.setText(Property_car.information_car.get("cilandr"));

    }
}
