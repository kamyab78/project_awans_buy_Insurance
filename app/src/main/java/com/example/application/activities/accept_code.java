package com.example.application.activities;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.application.entity.Information;
import com.example.application.R;
import com.example.application.base.Request_Base;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class accept_code extends AppCompatActivity {
    Button taeed;
    EditText code;
    EditText submit_code;
    TextView txtv;
    TextView txt_shomare;
    Button btn_vorod;
    public static List<String>token;
    CountDownTimer countDownTimer;
    RelativeLayout safe;
    String timel;
    Button smscode;
    Button btn_submit;
    long timeleft = 60000;
    long timeleft2 = 60000;
    boolean timer;
    public static String zakhireyecode;
    private int mcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_code);
        txt_shomare = findViewById(R.id.txt_shomare);
submit_code=findViewById(R.id.submit_code);
        btn_vorod = findViewById(R.id.btn_vorod);
        btn_submit = findViewById(R.id.btn_submit);
        txtv = findViewById(R.id.txtv);
        txt_shomare.setText("کد تایید ارسال شده به شماره ی " + create.phonenumber + "را وارد کنید");
        send();
btn_vorod.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String code=submit_code.getText().toString();
        get_submit(code);
    }
});

/**********************************************************************************/
/**                                  for timer                                  **/
/*********************************************************************************/
        countDownTimer = new CountDownTimer(timeleft, 1000) {
            @Override
            public void onTick(long l) {
                timeleft = l;
                updatetimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();

    }

    public void updatetimer() {
        int deighe = (int) timeleft / 60000;
        int sanie = (int) timeleft % 60000 / 1000;
        String timel = deighe + ":";
        if (sanie < 10) timel += "0";
        timel += sanie;
        txtv.setText(timel);
        if (timel.equals("0:00")) {
            dobare();
        }
    }

    public void updatetimer2() {
        int deighe = (int) timeleft2 / 60000;
        int sanie = (int) timeleft2 % 60000 / 1000;
        timel = deighe + ":";
        if (sanie < 10) timel += "0";
        timel += sanie;
        txtv.setText(timel);
        if (timel.equals("0:00")) {
            dobare();
        }


    }
/************************************************************************************************/
/**                                 again timer                                                **/
    /************************************************************************************************/
    public void dobare() {

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send();
                timeleft2 = 60000;
                countDownTimer = new CountDownTimer(timeleft2, 1000) {
                    @Override
                    public void onTick(long l) {
                        timeleft2 = l;
                        updatetimer2();
                    }

                    @Override
                    public void onFinish() {

                    }
                }.start();
            }
        });
    }
    /*******************************************************************************************/
    /**                                    sms request                                       **/
    /******************************************************************************************/

    public void send() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://185.208.174.118:8000").addConverterFactory(GsonConverterFactory.create()).build();
        Request_Base service = retrofit.create(Request_Base.class);
//        RequestBody requestBody =RequestBody.create(JSON, jsonObject.toString())
        String json = "{\"commandBodyInJson\" :  \"{\\\"phone\\\":\\\"" + create.phonenumber + "\\\"}\"}";
        final RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), json);
        Call call = service.send(requestBody);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getBaseContext(), " ارسال کد با موفقیت انجام شد ", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getBaseContext(), "https fail " + response.errorBody(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getBaseContext(), " ارسال کد با موفقیت انجام نشد" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
    public void get_submit(final String code){
        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://185.208.174.118:8000").addConverterFactory(GsonConverterFactory.create()).build();
        Request_Base service=retrofit.create(Request_Base.class);
        String jason="{\"commandBodyInJson\" :  \"{\\\"phone\\\":\\\""+create.phonenumber+"\\\",\\\"currentPassword\\\":\\\""+code+"\\\"}\"}";
        final RequestBody requestBody=RequestBody.create(MediaType.parse("application/json"),jason);
        Call <Information>call=service.confirm_code(requestBody);
        call.enqueue(new Callback<Information>() {
            @Override
            public void onResponse(Call<Information> call, Response<Information> response) {
                if(response.isSuccessful()) {
//                    Information information=new Information();
//                    Gson gson = new Gson();
//                     information = gson.fromJson(response.body().toString(), Information.class);
                    if (response.body() != null) {
                        Information information = response.body();
                        System.out.println(information.getStatus());
                        if (information.getStatus().equals("011")) {
                            Toast.makeText(getApplicationContext(), "کد وارد شده درست نیست", Toast.LENGTH_LONG).show();
                        }
                        else {
                                if (information.getCustomerLogin().getToken() == null) {
                                    Intent intent = new Intent(accept_code.this, Signup.class);
                                    intent.putExtra("code",code);
                                    startActivity(intent);
                                }


                                else  {
                                    Intent intent = new Intent(accept_code.this, firstpage.class);
                                    Intent intent1=new Intent(accept_code.this,profile.class);
                                    token=new ArrayList<>();
                                    token.add(information.getCustomerLogin().getToken());
                                    token.add(information.getCustomerLogin().getFirstname());
                                    token.add(information.getCustomerLogin().getLastname());

                                    startActivity(intent);
                                }

                        }
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),"pasokhi daryaft nashod", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call <Information>call, Throwable t) {

            }
        });
    }

}
