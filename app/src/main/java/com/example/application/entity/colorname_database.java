package com.example.application.entity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class colorname_database extends SQLiteOpenHelper {
    public static final String Table_colorname = "colorname";
    public static final String keycolorname = "COLORNAME";

    public colorname_database(Context context) {
        super(context, Table_colorname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create TABLE " + Table_colorname + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,COLORNAME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXIST" + Table_colorname);
    }

    public boolean insert_colorname(String colorname) {
        SQLiteDatabase sql = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(keycolorname, colorname);
        long chek = sql.insert(Table_colorname, null, contentValues);
        if (chek == -1) {
            return false;
        } else {
            return true;
        }
    }
}
