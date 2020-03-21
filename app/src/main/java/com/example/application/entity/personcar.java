package com.example.application.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class personcar {
    public ArrayList getCar() {
        return car;
    }

    public void setCar(ArrayList car) {
        this.car = car;
    }

    @SerializedName("cars")
    @Expose
    private ArrayList car;

}
