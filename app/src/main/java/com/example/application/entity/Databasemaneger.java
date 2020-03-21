package com.example.application.entity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Databasemaneger extends SQLiteOpenHelper {
    public static final String Database_name="information.db";
    public static final String Table_name="data";
    public static final String keyid="ID";
    public static final String keyusername="USERNAME";
    public static final String keypassword="PASSWORD";
    public static final String keyemail="EMAIL";
    public static final String keyphone="PHONE";
    public static final String Table_cities="cities";
    public static final String keynamecities="CITIES";
    public static final String Table_routes="routes";
    public static final String keynameroutes="ROUTES";
    public static final String Table_carmodel="carmodel";
    public static final String keycarmodel="CARMODELS";
    public static final String Table_cartype="cartype";
    public static final String keycartype="CARTYPE";
    public static final String Table_colorname="colorname";
    public static final String keycolorname="COLORNAME";


    public Databasemaneger(Context context) {
        super(context, Table_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create TABLE "+Table_cities +"(ID INTEGER PRIMARY KEY AUTOINCREMENT,CITIES TEXT)" );
        db.execSQL("create TABLE "+Table_routes +"(ID INTEGER PRIMARY KEY AUTOINCREMENT,ROUTES TEXT)" );
        db.execSQL("create TABLE "+Table_carmodel +"(ID INTEGER PRIMARY KEY AUTOINCREMENT,CARMODELS TEXT)" );
        db.execSQL("create TABLE "+Table_cartype +"(ID INTEGER PRIMARY KEY AUTOINCREMENT,CARTYPE TEXT)" );
        db.execSQL("create TABLE "+Table_colorname +"(ID INTEGER PRIMARY KEY AUTOINCREMENT,COLORNAME TEXT )" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXIST"+Table_cities);
        db.execSQL("DROP TABLE IF EXIST"+Table_routes);
        db.execSQL("DROP TABLE IF EXIST"+Table_carmodel);
        db.execSQL("DROP TABLE IF EXIST"+Table_cartype);
        db.execSQL("DROP TABLE IF EXIST"+Table_colorname);
        onCreate(db);

    }
    public boolean insert_cities(String cities) {
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(keynamecities, cities);;
        long chek = sql.insert(Table_cities, null, contentValues);
        if (chek == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean insert_routes(String routes) {
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(keynameroutes, routes);;
        long chek = sql.insert(Table_routes, null, contentValues);
        if (chek == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean insert_carmodel(String carmodel) {
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(keycarmodel, carmodel);;
        long chek = sql.insert(Table_carmodel, null, contentValues);
        if (chek == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean insert_cartype(String cartype) {
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(keycartype, cartype);;
        long chek = sql.insert(Table_cartype, null, contentValues);
        if (chek == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean insert_colorname(String colorname) {
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(keycolorname, colorname);;
        long chek = sql.insert(Table_colorname, null, contentValues);
        if (chek == -1) {
            return false;
        } else {
            return true;
        }
    }



//    public boolean insert_information(String username,String password,String email,String phone) {
//        SQLiteDatabase sql = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(keyusername, username);
//        contentValues.put(keypassword, password);
//        contentValues.put(keyemail, email);
//        contentValues.put(keyphone,phone);
//        long chek = sql.insert(Table_name, null, contentValues);
//        if (chek == -1) {
//            return false;
//        } else {
//            return true;
//        }
//    }
//    public String getpass(String username){
//        String pass = null;
//        SQLiteDatabase sql = this.getWritableDatabase();
//        Cursor cursor = null;
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
//            cursor = sql.rawQuery("SELECT PASSWORD FROM data " + " where USERNAME=? ", new String[]{username},null);
//        }
////        if(cursor==null){
////           return "vojod nadarad";
////        }
////        else {
//        if (cursor.moveToFirst()){
//            pass=cursor.getString(cursor.getColumnIndex("PASSWORD"));
//        }
//        return pass;
////        }
//
//
////String SQL="SELECT * FROM"
//
//    }
}
