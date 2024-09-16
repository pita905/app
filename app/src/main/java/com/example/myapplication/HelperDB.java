package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class HelperDB extends SQLiteOpenHelper {
    public static final String DB_FILE = "itamar's_food_delivery.db";
    public static final String USERS_TEBLE = "Users";
    public static final String USERS_NAME = "Users_Name";
    public static final String USERS_PWD = "Users_Pwd";
    public static final String USERS_EMAIL = "User_Email";
    public static final String USER_PHONE = "User_Phone";

    public HelperDB(@Nullable Context context) {
        super(context,DB_FILE,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
    db.execSQL(buildUserTable());
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){

    }
    public String buildUserTable(){
        String st = "CREATE TABLE IF NOT EXISTS"+USERS_TEBLE;
        st+="("+USERS_NAME+"TEXT,";
        st+=USERS_PWD+"TEXT,";
        st+=USERS_EMAIL+"TEXT,";
        st+=USER_PHONE+"TEXT);";
        return st;
    }

}
