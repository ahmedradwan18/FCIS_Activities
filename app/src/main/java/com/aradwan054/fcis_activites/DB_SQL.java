package com.aradwan054.fcis_activites;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DB_SQL extends SQLiteOpenHelper {

    public static final String DBname = "favorite.db";

    public DB_SQL(Context context) {
        super(context, DBname, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table mytable (id INTEGER PRIMARY KEY AUTOINCREMENT ,name TEXT )");

    }

    public boolean insertData(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        long result = db.insert("mytable", null, contentValues);
        if (result == -1) return false;
        else return true;
    }


    public Integer delete(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("mytable", "id = ?", new String[]{id});
    }


    public ArrayList getAllRecords() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from mytable", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            String t1 = res.getString(0);
            String t2 = res.getString(1);
            arrayList.add(t1 + " - " + t2);
            res.moveToNext();
        }
        return arrayList;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS mytable");
        onCreate(db);

    }
}
