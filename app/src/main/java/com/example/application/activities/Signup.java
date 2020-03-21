package com.example.application.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.application.R;
import com.example.application.base.Request_Base;
import com.example.application.entity.Information;

import java.util.Arrays;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Signup extends AppCompatActivity {
    Button btn;
    EditText edite_email;
    EditText edite_name;
    EditText edite_family;
    EditText edite_code_melli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        edite_code_melli = findViewById(R.id.edite_code_melli);
        edite_email = findViewById(R.id.edite_email);
        edite_family = findViewById(R.id.edite_family);
        edite_name = findViewById(R.id.edite_name);
        btn = findViewById(R.id.btn);
        Intent intent = getIntent();
        final String code = intent.getStringExtra("code");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cod_melli, email, family_name, name;
                cod_melli = edite_code_melli.getText().toString();
                email = edite_email.getText().toString();
                family_name = edite_family.getText().toString();
                name = edite_name.getText().toString();
                if (name != null) {
                    if (family_name != null) {
                        if (cod_melli != null) {
                            if (validateMelliCode(cod_melli)) {
                                if (email != null) {
                                    if (isValidEmail(email)) {
                                        Retrofit retrofit = new Retrofit.Builder().baseUrl("http:185.208.174.118:8000").addConverterFactory(GsonConverterFactory.create()).build();
                                        final Request_Base service = retrofit.create(Request_Base.class);
                                        Information information = new Information();
//                                        String pass = information.getCustomerLogin().getCurrentPassword();
                                        String json = "{ \"token\" : \"\" , \"username\" : \"" + create.phonenumber + "\" ,  \"commandBodyInJson\" :  \"{\\\"firstname\\\":\\\"" + name + "\\\",\\\"lastname\\\":\\\"" + family_name + "\\\" , \\\"current_password\\\":\\\"\\\",\\\"phone\\\":\\\"" + create.phonenumber + "\\\",\\\"nationalCode\\\":\\\"" + cod_melli + "\\\",\\\"mail\\\":\\\"" + email + "\\\" }\"}";
                                        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
                                        Call call = service.Sign_up(requestBody);
                                        call.enqueue(new Callback() {
                                            @Override
                                            public void onResponse(Call call, Response response) {
                                                if (response.isSuccessful()) {
                                                    Toast.makeText(getApplicationContext(), "با موفقیت انجام شد", Toast.LENGTH_LONG).show();
                                                    String Json = "{\"commandBodyInJson\" :  \"{\\\"phone\\\":\\\"" + create.phonenumber + "\\\",\\\"currentPassword\\\":\\\"" + code + "\\\"}\"}";
                                                    RequestBody rb = RequestBody.create(MediaType.parse("application/json"), Json);
                                                    Call<Information> call11 = service.confirm_code(rb);
                                                    call11.enqueue(new Callback<Information>() {
                                                        @Override
                                                        public void onResponse(Call<Information> call, Response<Information> response) {
                                                            if (response.isSuccessful()) {
//                                                                System.out.println("succes");
                                                                Information information1 = response.body();
                                                                if (information1.getCustomerLogin().getToken() != null) {
                                                                    Intent intent = new Intent(Signup.this, firstpage.class);
                                                                    startActivity(intent);
                                                                }
                                                            }
                                                        }

                                                        @Override
                                                        public void onFailure(Call<Information> call, Throwable t) {

                                                        }
                                                    });
                                                }
                                            }

                                            @Override
                                            public void onFailure(Call call, Throwable t) {
                                                Toast.makeText(getApplicationContext(), "با موفقیت انجام نشد", Toast.LENGTH_LONG).show();
                                            }
                                        });
                                    } else {
                                        Toast.makeText(getApplicationContext(), "ایمیل صحیح را وارد کنید", Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    final Retrofit retrofit = new Retrofit.Builder().baseUrl("http:185.208.174.118:8000").addConverterFactory(GsonConverterFactory.create()).build();
                                    final Request_Base service = retrofit.create(Request_Base.class);
                                    final Information information = new Information();
//                                    String pass = information.getCustomerLogin().getCurrentPassword();
                                    String json = "{ \"token\" : \"\" , \"username\" : \"" + create.phonenumber + "\" ,  \"commandBodyInJson\" :  \"{\\\"firstname\\\":\\\"" + name + "\\\",\\\"lastname\\\":\\\"" + family_name + "\\\" , \\\"current_password\\\":\\\"\\\",\\\"phone\\\":\\\"" + create.phonenumber + "\\\",\\\"nationalCode\\\":\\\"" + cod_melli + "\\\",\\\"mail\\\":\\\"\\\" }\"}";
                                    RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
                                    Call call = service.Sign_up(requestBody);
                                    call.enqueue(new Callback() {
                                        @Override
                                        public void onResponse(Call call, Response response) {
                                            if (response.isSuccessful()) {
                                                Toast.makeText(getApplicationContext(), "با موفقیت انجام شد", Toast.LENGTH_LONG).show();
//                                                String Json="{\"commandBodyInJson\" :  \"{\\\"phone\\\":\\\""+create.phonenumber+"\\\",\\\"currentPassword\\\":\\\"\\\"}\"}";
//                                                RequestBody rb=RequestBody.create(MediaType.parse("application/json"),Json);
//                                                Call<Information> call11=service.confirm_code(rb);
//                                                call11.enqueue(new Callback<Information>() {
//                                                    @Override
//                                                    public void onResponse(Call<Information> call, Response<Information> response) {
//                                                        if (response.isSuccessful()) {
//                                                            Information information1 = response.body();
//                                                            if (information1.getCustomerLogin().getToken()!=null){
//                                                                Intent intent =new Intent(Signup.this,firstpage.class);
//                                                                startActivity(intent);
//                                                            }
//                                                        }
//                                                    }
//
//                                                    @Override
//                                                    public void onFailure(Call<Information> call, Throwable t) {
//
//                                                    }
//                                                });
                                            }
                                        }

                                        @Override
                                        public void onFailure(Call call, Throwable t) {
                                            Toast.makeText(getApplicationContext(), "با موفقیت انجام نشد", Toast.LENGTH_LONG).show();
                                        }
                                    });
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "کد ملی صحیح را وارد کنید", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "کد ملی خود را وارد کنید", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "نام خانوادگی خود را وارد کنید", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "نام خود را وارد کنید", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private static boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public boolean validateMelliCode(String melliCode) {

        String[] identicalDigits = {"0000000000", "1111111111", "2222222222", "3333333333", "4444444444", "5555555555", "6666666666", "7777777777", "8888888888", "9999999999"};

        if (melliCode.trim().isEmpty()) {
//            Toast.makeText(getApplicationContext(), "Melli Code is empty", Toast.LENGTH_LONG).show();
            return false; // Melli Code is empty
        } else if (melliCode.length() != 10) {
//            Toast.makeText(getApplicationContext(), "Melli Code must be exactly 10 digits", Toast.LENGTH_LONG).show();
            return false; // Melli Code is less or more than 10 digits
        } else if (Arrays.asList(identicalDigits).contains(melliCode)) {
//            Toast.makeText(getApplicationContext(), "MelliCode is not valid (Fake MelliCode)", Toast.LENGTH_LONG).show();
            return false; // Fake Melli Code
        } else {
            int sum = 0;

            for (int i = 0; i < 9; i++) {
                sum += Character.getNumericValue(melliCode.charAt(i)) * (10 - i);
            }

            int lastDigit;
            int divideRemaining = sum % 11;

            if (divideRemaining < 2) {
                lastDigit = divideRemaining;
            } else {
                lastDigit = 11 - (divideRemaining);
            }

            if (Character.getNumericValue(melliCode.charAt(9)) == lastDigit) {
//                Toast.makeText(getApplicationContext(), "MelliCode is valid", Toast.LENGTH_LONG).show();
                return true;
            } else {
//                Toast.makeText(getApplicationContext(), "MelliCode is not valid", Toast.LENGTH_LONG).show();
                return false; // Invalid MelliCode
            }
        }
    }
}
