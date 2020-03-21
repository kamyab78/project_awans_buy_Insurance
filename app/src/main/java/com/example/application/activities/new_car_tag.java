package com.example.application.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.application.R;


public class new_car_tag extends Activity {
    EditText number_1;
    EditText harf;
    EditText number_2;
    EditText number_3;
    public static String aval;
    public static String alphabet;
    public static String dovom;
   public static String sevom;
    Button btn_next;
    EditText vin_edit;
public static String pelak;
String[] tab_name={"بازبینی","کارت خودرو","مشخصات خودرو","اطلاعات خودرو"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_new_tag_car);

        number_1 = findViewById(R.id.nubmer_1);
        number_2 = findViewById(R.id.number_2);
        number_3 = findViewById(R.id.number_3);
        vin_edit = findViewById(R.id.vin_edit);

//        stateProgressBar.setStateDescriptionData(tab_name);


        btn_next = findViewById(R.id.btn_next);
        harf = findViewById(R.id.harf);
        number_1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (number_1.getText().toString().length() == 2) {
                    aval = number_1.getText().toString();
                    harf.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        harf.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (harf.getText().toString().length() == 1) {
                    alphabet = harf.getText().toString();
                    number_2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        number_2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (number_2.getText().toString().length() == 3) {
                    dovom = number_2.getText().toString();
                    number_3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        number_3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (number_3.getText().toString().length() == 2) {
                    sevom = number_3.getText().toString();
                    number_1.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String vin = vin_edit.getText().toString();
                if (vin != null) {
                    if (aval != null) {
                        if (alphabet != null) {
                            if (dovom != null) {
                                if (sevom != null) {
                                    pelak = aval + "" + alphabet + "" + dovom + "" + sevom;
                                    Intent intent=new Intent(new_car_tag.this,Property_car.class);
                                    startActivity(intent);

                                }
                                else
                                Toast.makeText(getApplicationContext(), "شماره پلاک را وارد کنید", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "شماره پلاک را وارد کنید", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "شماره پلاک را وارد کنید", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "شماره پلاک را وارد کنید", Toast.LENGTH_LONG).show();
                    }
                } else {
                    if (aval != null) {
                        if (alphabet != null) {
                            if (dovom != null) {
                                if (sevom != null) {
                                    String pelak = aval + "" + alphabet + "" + dovom + "" + sevom;

                                }
                                Toast.makeText(getApplicationContext(), "شماره پلاک را وارد کنید", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "شماره پلاک را وارد کنید", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "شماره پلاک را وارد کنید", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "شماره پلاک را وارد کنید", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }
}
