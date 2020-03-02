package com.example.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


import java.util.ArrayList;

public class Databasehelper extends SQLiteOpenHelper {
    //User database
    public static final String DATABASE_NAME="register.db";
    public static final String TABLE_NAME="registration";
    public static final String COL_1="ID";
    public static final String COL_2="Name";
    public static final String COL_3="Password";
    //Cursor cursor;

    //Store database
   public static final String STORE_TABLE="store";
    //public static final String STORE_DATABASE="store.db";
    public static final String  KEY_ID="PID";
    public static final String KEY_NAME="Product_Name";
    public static final String KEY_PRICE="price";

    //public static final String COL_4="ID";
    //public static final String COL_5="ID";
    //public static final String COL_6="ID";
    public Databasehelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +"(ID INTEGER PRIMARY KEY,Name TEXT,Password TEXT)");
        db.execSQL("CREATE TABLE " + STORE_TABLE +"(PID INTEGER PRIMARY KEY,Product_Name TEXT,Price INTEGER)");
        //db.execSQL("INSERT INTO "+STORE_TABLE+" VALUES (1,'Biscuit',23 )");
        //db.execSQL("INSERT INTO "+STORE_TABLE+" VALUES (2,'Chips',25 )");
        //db.execSQL("INSERT INTO "+STORE_TABLE+" VALUES (3,'',34 )");
        //db.execSQL("INSERT INTO "+STORE_TABLE+" VALUES (1,'Biscuit',23 )");


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME );
    db.execSQL("DROP TABLE IF EXISTS " +STORE_TABLE);
    onCreate(db);
    }
   public Cursor viewData(){
        SQLiteDatabase db=this.getReadableDatabase();
        Main3Activity m= new Main3Activity();
        String query="Select * from " + STORE_TABLE + " where PID = " +m.myResult  ;
       Cursor cursor=db.rawQuery(query,null);


        //Cursor[] cursors={cursor,cursor1};

        return cursor;
   }
   /* public Cursor viewTotal()
    {
        SQLiteDatabase db1=this.getReadableDatabase();
        Main3Activity m= new Main3Activity();
        String priceQery=" Select price from store where PID= "+m.myResult;

        Cursor cursor1=db1.rawQuery(priceQery,null);
        return cursor1;

    }*/
    }



