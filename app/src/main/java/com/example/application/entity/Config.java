package com.example.application.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Config {


    public ArrayList getCities() {return cities;}

    public void setCities(ArrayList cities) {this.cities = cities;}

    public ArrayList getRoutes() {return routes;}

    public void setRoutes(ArrayList routes) {this.routes = routes;}

    public ArrayList getCarModels() {return carModels;}

    public void setCarModels(ArrayList carModels) {this.carModels = carModels;}

    public ArrayList getCarTypes() {return carTypes;}

    public void setCarTypes(ArrayList carTypes) {this.carTypes = carTypes;}

    public ArrayList getColors() {return colors;}

    public void setColors(ArrayList colors) {this.colors = colors;}

    @SerializedName("cities")
    @Expose
    private ArrayList <City> cities;


    @SerializedName("routes")
    @Expose
    private ArrayList<Routes> routes;


    @SerializedName("carModels")
    @Expose
    private ArrayList<Carmodel> carModels;


    @SerializedName("carTypes")
    @Expose
    private ArrayList<Cartype> carTypes;


    @SerializedName("colors")
    @Expose
    private ArrayList <Colors> colors;





//    public class cities{
//        public String getName() {return name;}
//        public void setName(String name) {this.name = name;}
//
//        @SerializedName("name")
//        @Expose
//        private String name;
//    }
//
//
//
//
//
//    public class  routes{
//        public String getName() {return name;}
//        public void setName(String name) {this.name = name;}
//
//        @SerializedName("name")
//        @Expose
//        private String name;
//    }
//
//
//
//
//    public class carModels{
//        public String getCarModel() {return carModel;}
//        public void setCarModel(String carModel) {this.carModel = carModel;}
//
//        @SerializedName("carModel")
//        @Expose
//        private String carModel;
//    }
//
//
//
//
//
//    public class carTypes{
//        public String getCarType() {return carType;}
//        public void setCarType(String carType) {this.carType = carType;}
//
//        @SerializedName("carType")
//        @Expose
//        private String carType;
//    }
//
//
//
//
//
//    public class colors{
//        public String getColorName() {return colorName;}
//        public void setColorName(String colorName) {this.colorName = colorName;}
//
//        @SerializedName("colorName")
//        @Expose
//        private String colorName;
//    }
}
