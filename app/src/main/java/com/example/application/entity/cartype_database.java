package com.example.application.entity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class cartype_database extends SQLiteOpenHelper {
    public static final String Table_cartype="cartype";
    public static final String keycartype="CARTYPE";
    public static final String keyid="ID";
    public cartype_database(Context context) {
        super(context, Table_cartype, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create TABLE "+Table_cartype +"(ID INTEGER PRIMARY KEY AUTOINCREMENT,CARTYPE TEXT , ID TEXT)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXIST"+Table_cartype);
    }

    public boolean insert_cartype(String cartype ){
        SQLiteDatabase sql=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(keycartype,cartype);
//        contentValues.put(keyid,id);
        long chek = sql.insert(Table_cartype, null, contentValues);
        if (chek == -1) {
            return false;
        } else {
            return true;
        }
    }


    public List<String> gettype(){
        List<String> gettype=new ArrayList<>();
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            cursor = db.rawQuery("SELECT CARTYPE FROM cartype",null);
        }
        if (cursor==null){
            gettype.add("0");
        }
        else {
            while (cursor.moveToFirst()) {
                gettype.add(cursor.getString(cursor.getColumnIndex("CARTYPE")));
            }
        }
        return  gettype;
    }
}
