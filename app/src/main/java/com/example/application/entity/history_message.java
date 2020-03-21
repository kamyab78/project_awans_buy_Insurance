package com.example.application.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class history_message {
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<message> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(List<message> historyList) {
        this.historyList = historyList;
    }

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("historyList")
    @Expose
    private List<message> historyList;

}
