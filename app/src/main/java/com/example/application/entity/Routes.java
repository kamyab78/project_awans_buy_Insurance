package com.example.application.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Routes {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCities() {
        return cities;
    }

    public void setCities(String cities) {
        this.cities = cities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("cities")
    @Expose
    private String cities;

    @SerializedName("id")
    @Expose
    private String id;

}
