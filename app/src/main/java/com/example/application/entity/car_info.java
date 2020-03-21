package com.example.application.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class car_info {
    public car_info.car getCar() {return car;}
    public void setCar(car_info.car car) {this.car = car;}

    @SerializedName("car")
    @Expose
    private car car;



    public class car{

    }
}
