package com.example.application.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Information {
    public Information.customerLogin getCustomerLogin() {
        return customerLogin;
    }

    public void setCustomerLogin(Information.customerLogin customerLogin) {
        this.customerLogin = customerLogin;
    }

    @SerializedName("customerLogin")
    @Expose
    private customerLogin customerLogin;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @SerializedName("status")
    @Expose
    private String status;

    public class customerLogin
    {
        @SerializedName("firstname")
        @Expose
        private String firstname;


        @SerializedName("lastname")
        @Expose
        private String lastname;


        @SerializedName("mail")
        @Expose
        private String mail;


        @SerializedName("token")
        @Expose
        private String token;

        public String getCurrentPassword() {
            return currentPassword;
        }

        public void setCurrentPassword(String currentPassword) {
            this.currentPassword = currentPassword;
        }

        @SerializedName("currentPassword")
        @Expose
        private String currentPassword;


        public String getFirstname () {
        return firstname;
    }

        public void setFirstname (String firstname){
        this.firstname = firstname;
    }

        public String getLastname () {
        return lastname;
    }

        public void setLastname (String lastname){
        this.lastname = lastname;
    }

        public String getMail () {
        return mail;
    }

        public void setMail (String mail){
        this.mail = mail;
    }

        public String getToken () {
        return token;
    }

        public void setToken (String token){
        this.token = token;
    }
    }
}
