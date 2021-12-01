package com.example.azkarseb7ty;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDataBase extends SQLiteOpenHelper {
    public MyDataBase(Context context) {
        super(context, "Azkar.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table data (id number(1), result number(8))");
        sqLiteDatabase.execSQL("insert into data values (1,0);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if (sqLiteDatabase.equals(null)){
            sqLiteDatabase.execSQL("create table data (id number(1), result number(8))");
        }
    }
}
