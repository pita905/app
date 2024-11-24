package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class HelperDB extends SQLiteOpenHelper {
    public static final String DB_FILE = "User.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_USERS = "Users";
    //public static final String ID = "ID";
    public static final String User_Name = "Name";
    public static final String User_Pwd = "Pwd";
    public static final String User_Email = "Email";
    public static final String User_Phone = "Phone";
    private final Context context;


//creating table
    private static final String CREATE_TABLE_USERS = " CREATE TABLE "
            + TABLE_USERS + "("
            + User_Name + "TEXT, "
            + User_Pwd + "TEXT, "
            + User_Email + "TEXT, "
            + User_Phone + "TEXT"
            + ")";
    public HelperDB(@Nullable Context context) {

        super(context, DB_FILE, null, DATABASE_VERSION);
        this.context = context;
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    //adding new user infomation in to database
    public void insertUser(UserDetails user) {
        ContentValues values = new ContentValues();
        values.put(HelperDB.User_Name, user.getUSERS_NAME());
        values.put(HelperDB.User_Pwd, user.getUSERS_PWD());
        values.put(HelperDB.User_Email, user.getUSERS_EMAIL());
        values.put(HelperDB.User_Phone, user.getUSER_PHONE());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_USERS, null, values);
        db.close();
    }
//getting all data from database in to cursor res
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_USERS, null);
        return res;
    }

}