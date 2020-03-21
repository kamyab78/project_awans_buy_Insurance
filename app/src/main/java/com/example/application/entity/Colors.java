package com.example.application.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Colors {

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @SerializedName("colorName")
    @Expose
    private String colorName;


    @SerializedName("id")
    @Expose
    private String id;
}
