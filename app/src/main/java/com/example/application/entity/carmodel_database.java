package com.example.application.entity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class carmodel_database extends SQLiteOpenHelper {
    public static final String Table_carmodel = "carrmodel";
    public static final String keycarmodel = "CARMODEL";

    public carmodel_database(Context context) {
        super(context, Table_carmodel, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create TABLE " + Table_carmodel + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,CARMODEL TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXIST" + Table_carmodel);
    }

    public boolean insert_carmodel(String carmodel) {
        SQLiteDatabase sql = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(keycarmodel, carmodel);
        long chek = sql.insert(Table_carmodel, null, contentValues);
        if (chek == -1) {
            return false;
        } else {
            return true;
        }
    }
}
