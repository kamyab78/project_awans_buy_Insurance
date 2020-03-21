package com.example.application.base;

import com.example.application.activities.Config_page;
import com.example.application.entity.Config;
import com.example.application.entity.Information;
import com.example.application.entity.car_info;
import com.example.application.entity.history_message;
import com.example.application.entity.personcar;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Request_Base {
    @POST("/app/confirmPhone")
//    @Multipart
    @Headers("Content-Type: application/json")
//    @FormUrlEncoded
//    Call<JSONObject> send (@Field("phone") String number);
    Call<ResponseBody> send (@Body RequestBody requestBody);

    @POST("/app/customerSignIn")
    @Headers("Content-Type: application/json")
    Call<Information> confirm_code(@Body RequestBody requestBody);

    @POST("/app/customerSignUp")
@Headers("Content-Type: application/json")
    Call<ResponseBody>Sign_up(@Body RequestBody requestBody);

    @POST("/app/Config")
    @Headers("Content-Type: application/json")
    Call<Config> config(@Body RequestBody requestBody);

//    @POST("")
//    @Headers("Content-Type: application/json")
//    Call<>car=(@Body RequestBody requestbody);

    @POST("/app/customerSignOut")
    @Headers("Content-Type: application/json")
    Call<ResponseBody> Sign_out(@Body RequestBody requestBody);

    @POST("/app/carInfo")
    @Headers("Content-Type: application/json")
    Call<car_info> car_info(@Body RequestBody requestBody);

    @POST("/app/getPersonCars")
    @Headers("Content-Type: application/json")
    Call<personcar> person_car(@Body RequestBody requestBody);

    @POST("/app/getHistoryOfMessages")
    @Headers("Content-Type: application/json")
    Call<history_message> get_message(@Body RequestBody requestBody);
}

