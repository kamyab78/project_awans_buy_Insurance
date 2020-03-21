package com.example.application.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.application.R;
import com.example.application.entity.cartype_database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Property_car extends Activity {
    TextView num1;
    TextView alef;
    TextView num2;
    TextView iran;
    EditText silandr;
    Button btn_edame;
    Spinner spin_noe, spin_model, spin_color, spin_karbari;
public static HashMap<String , String>information_car=new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_car);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        alef = findViewById(R.id.alef);
        iran = findViewById(R.id.iran);
btn_edame=findViewById(R.id.btn_taeed);

        num1.setText(new_car_tag.aval);
        alef.setText(new_car_tag.alphabet);
        num2.setText(new_car_tag.dovom);
        iran.setText(new_car_tag.sevom);
btn_edame.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(Property_car.this,image_car.class);
        startActivity(intent);
    }
});
silandr=findViewById(R.id.silandr);
        spin_noe = findViewById(R.id.spin_noe);
        spin_model = findViewById(R.id.spin_model);
        spin_color = findViewById(R.id.spin_color);
        spin_karbari = findViewById(R.id.spin_carbari);
        List<String> noe = new ArrayList<>();
        List<String> model = new ArrayList<>();
        List<String> carbari = new ArrayList<>();
        List<String> color = new ArrayList<>();
        carbari.add("سواری");
        for (int i = 0; i < Config_page.cartype1.size(); i++) {
            noe.add(Config_page.cartype1.get(i).getCarType());
        }
        for (int i = 0; i < Config_page.carmodel1.size(); i++) {
            model.add(Config_page.carmodel1.get(i).getCarModel());
        }
        for (int i = 0; i < Config_page.colorname1.size(); i++) {
            color.add(Config_page.colorname1.get(i).getColorName());
        }
        ArrayAdapter<String> item_noe = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, noe);
        item_noe.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spin_noe.setAdapter(item_noe);
        spin_noe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String noe = adapterView.getItemAtPosition(i).toString();
                information_car.put("noe" , noe);
                Toast.makeText(getApplicationContext(), "select" + noe, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> item_model = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, model);
        item_model.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spin_model.setAdapter(item_model);
        spin_model.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String model = adapterView.getItemAtPosition(i).toString();
                information_car.put("model" , model);
                Toast.makeText(getApplicationContext(), "select" + model, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> item_color = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, color);
        spin_color.setAdapter(item_color);
        spin_color.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String color = adapterView.getItemAtPosition(i).toString();
                information_car.put("color" , color);
                Toast.makeText(getApplicationContext(), "select" + color, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> item_karbari=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,carbari);
        spin_karbari.setAdapter(item_karbari);
        spin_karbari.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String karbari=adapterView.getItemAtPosition(i).toString();
                information_car.put("karbari" , karbari);
                Toast.makeText(getApplicationContext(),"select"+karbari,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        String cilandr=silandr.getText().toString();
        information_car.put("cilandr" , cilandr);
    }
}
