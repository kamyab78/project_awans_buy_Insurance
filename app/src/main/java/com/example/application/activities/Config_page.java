package com.example.application.activities;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.application.MainActivity;
import com.example.application.R;
import com.example.application.base.Request_Base;
import com.example.application.entity.Carmodel;
import com.example.application.entity.Cartype;
import com.example.application.entity.City;
import com.example.application.entity.Colors;
import com.example.application.entity.Config;
import com.example.application.entity.Routes;
import com.example.application.entity.carmodel_database;
import com.example.application.entity.cartype_database;
import com.example.application.entity.city_database;
import com.example.application.entity.colorname_database;
import com.example.application.entity.route_database;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class Config_page extends AppCompatActivity {
    Button btn;
    public static List<City>city1;
city_database city=new city_database(this);
colorname_database colorname=new colorname_database(this);
public static  List<Cartype> cartype1;
public static  List<Routes>routes;
public  static  List<Carmodel>carmodel1;
public static  List<Colors>colorname1;
public static HashMap<String  ,String >shahr;
public static HashMap<String  , String > type=new HashMap<>();
public static HashMap<String , String> jade=new HashMap<>();
public static HashMap<String , String> modrel_car=new HashMap<>();
public static HashMap<String  , String > rang=new HashMap<>();
cartype_database cartype=new cartype_database(this);
carmodel_database carmodel=new carmodel_database(this);
route_database route=new route_database(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_page);
btn=findViewById(R.id.button);
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(Config_page.this, last_step.class);
        startActivity(intent);
    }
});
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http:185.208.174.118:8000").addConverterFactory(GsonConverterFactory.create()).build();
        Request_Base request_base = retrofit.create(Request_Base.class);
        String json = "{\"token\":\"\" , \"username\" : \"\" , \"commandBodyInJson\" :  \"\"}";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
        Call<Config> call = request_base.config(requestBody);
        call.enqueue(new Callback<Config>() {
            @Override
            public void onResponse(Call<Config> call, Response<Config> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Config config = response.body();


                        city1 =config.getCities();
                        System.out.println(city1.size());
                        for (int i = 0; i < city1.size(); i++) {
                            city.insert_city(city1.get(i).getName());
//                            System.out.println(city1.get(i).getName());
                        }
//                        for (int i = 0; i <city1.size() ; i++) {
//                            shahr.put(city1.get(i).getId(),city1.get(i).getName());
//                        }


                       routes = config.getRoutes();
                        for (int i = 0; i < routes.size(); i++) {
                            route.insert_route(routes.get(i).toString());
                        }
                        for (int i = 0; i <routes.size() ; i++) {
                            jade.put(routes.get(i).getId(),routes.get(i).getName());
                        }

                       carmodel1 = config.getCarModels();
                        for (int i = 0; i < carmodel1.size(); i++) {
                            carmodel.insert_carmodel(carmodel1.get(i).toString());
                        }
                        for (int i = 0; i <carmodel1.size() ; i++) {
                            modrel_car.put(carmodel1.get(i).getId(),carmodel1.get(i).getCarModel());
                        }

                        cartype1 = config.getCarTypes();
                        for (int i = 0; i < cartype1.size(); i++) {
                            cartype.insert_cartype(cartype1.get(i).getCarType());
//                            System.out.println(cartype1.get(i).getCarType());
                        }
                        for (int i = 0; i <cartype1.size() ; i++) {
                            type.put(cartype1.get(i).getId(),cartype1.get(i).getCarType());
                        }


                        colorname1 = config.getColors();
                        for (int i = 0; i <colorname1.size(); i++) {
                            colorname.insert_colorname(colorname1.get(i).toString());
                        }
                        for (int i = 0; i <colorname1.size() ; i++) {
                            rang.put(colorname1.get(i).getId(),colorname1.get(i).getColorName());
                        }
//                        db.insert_cities(config.getCities().getName());
//                        db.insert_routes(config.getRoutes().getName());
//                        db.insert_carmodel(config.getCarModels().getCarModel());
//                        db.insert_cartype(config.getCarTypes().getCarType());
//                        db.insert_colorname(config.getColors().getColorName());
                        Toast.makeText(getApplicationContext(), "add shod", Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(Config_page.this,MainActivity.class);
                        startActivity(intent);
                    }
                } else
                    Toast.makeText(getApplicationContext(), "nashod", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Config> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "on fail" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
