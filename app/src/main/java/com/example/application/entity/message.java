package com.example.application.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class message {

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    @SerializedName("rejectReason")
    @Expose
    private String rejectReason;


//
//    @SerializedName("id")
//    @Expose
//    private String id;

}
