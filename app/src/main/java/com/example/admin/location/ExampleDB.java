package com.example.admin.location;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExampleDB extends SQLiteOpenHelper {




    public  static  final String DB_NAME="LOCATION";
    public  static  final String TABLE_NAME="mylocation";
    public  static  final String Latitude="latitude";
    public  static  final String Longitude="longitude";
    ArrayList<Map<String,String>> arrayList=new ArrayList<>();



    public ExampleDB(Context context) {
        super(context, DB_NAME, null, 1);
    }





    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table if not exists mylocation(latitude double(50),longitude double(50))");
        Log.i("creation","done");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);

    }
    public void saveData(double latitude, double longitude){

        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Latitude,latitude);
        contentValues.put(Longitude,longitude);
        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        Log.i("Data","inserted");

    }

    public ArrayList<Map<String, String>> getUserData() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        ArrayList<Map<String, String>> arrayList = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery("Select * from mylocation",null);


        if (cursor != null && cursor.moveToFirst()) {

            while (!cursor.isAfterLast()) {
                Map<String, String> map = new HashMap();
                map.put(Latitude, String.valueOf(cursor.getDouble(0)));
                map.put(Longitude, String.valueOf(cursor.getDouble(1)));


                arrayList.add(map);

                cursor.moveToNext();
            }
        }
        return arrayList;
    }

}