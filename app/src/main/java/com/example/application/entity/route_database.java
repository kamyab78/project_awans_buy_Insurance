package com.example.application.entity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class route_database extends SQLiteOpenHelper {
    public static final String Table_route = "route";
    public static final String keyroute = "ROUTE";

    public route_database(Context context) {
        super(context, Table_route, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create TABLE " + Table_route + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,ROUTE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXIST" + Table_route);
    }

    public boolean insert_route(String route) {
        SQLiteDatabase sql = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(keyroute, route);
        long chek = sql.insert(Table_route, null, contentValues);
        if (chek == -1) {
            return false;
        } else {
            return true;
        }
    }
}
