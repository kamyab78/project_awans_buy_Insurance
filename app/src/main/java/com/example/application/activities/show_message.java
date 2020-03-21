package com.example.application.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.application.R;
import com.example.application.base.Request_Base;
import com.example.application.entity.history_message;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class show_message extends AppCompatActivity {
Context context=this;
RelativeLayout lay;
int[]photo={R.drawable.pms};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_message);
lay=findViewById(R.id.lay);
        Retrofit retrofit=new Retrofit.Builder().baseUrl("http:185.208.174.118:8000").addConverterFactory(GsonConverterFactory.create()).build();
        Request_Base request_base=retrofit.create(Request_Base.class);
        String json = "{\"token\":\"" + accept_code.token.get(0) + "\",\"username\":\"" + create.phonenumber + "\",\"commandBodyInJson\" :  \"{}\"}";
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json"),json);
        Call<history_message> call=request_base.get_message(requestBody);
        call.enqueue(new Callback<history_message>() {
            @Override
            public void onResponse(Call<history_message> call, Response<history_message> response) {
                if(response.isSuccessful()){
                    if (response.body()!=null){
                        history_message history_message=response.body();
                        if (history_message.getStatus().equals("001")){
                            Toast.makeText(getApplicationContext(),"اجازه دسترسی ندارید",Toast.LENGTH_LONG).show();
                        }
                        else {
                           if (history_message.getHistoryList().size()==0){
                               ImageView imageView=new ImageView(context);
                               imageView.setImageResource(photo[0]);
                               imageView.setTranslationX(0);
                               imageView.setTranslationY(0);
                               lay.addView(imageView);
                           }


                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"khali",Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"nashod",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<history_message> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"fail",Toast.LENGTH_LONG).show();
            }
        });
    }

}

