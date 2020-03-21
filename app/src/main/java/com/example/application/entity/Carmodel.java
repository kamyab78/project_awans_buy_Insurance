package com.example.application.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Carmodel {
    public String getCarTypeId() {
        return carTypeId;
    }

    public void setCarTypeId(String carTypeId) {
        this.carTypeId = carTypeId;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @SerializedName("carTypeId")
    @Expose
    private String carTypeId;

    @SerializedName("carModel")
    @Expose
    private String carModel;

    @SerializedName("id")
    @Expose
    private String id;
}
