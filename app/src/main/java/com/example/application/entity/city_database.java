package com.example.application.entity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class city_database extends SQLiteOpenHelper {
    public static final String Table_city = "city";
    public static final String keycity = "CITY";
    public static final  String keyid="ID";

    public city_database(Context context) {
        super(context, Table_city, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create TABLE " + Table_city + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,CITY TEXT,ID TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXIST" + Table_city);
    }

    public boolean insert_city(String city ) {
        SQLiteDatabase sql = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(keycity, city);
//        contentValues.put(keyid,id);
        long chek = sql.insert(Table_city, null, contentValues);
        if (chek == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean insert_id(String id ) {
        SQLiteDatabase sql = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(keyid, id);
//        contentValues.put(keyid,id);
        long chek = sql.insert(Table_city, null, contentValues);
        if (chek == -1) {
            return false;
        } else {
            return true;
        }
    }
}
