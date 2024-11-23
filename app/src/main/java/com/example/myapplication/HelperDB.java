package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class HelperDB extends SQLiteOpenHelper {
    public static final String DB_FILE = "User.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_USERS = "Users";
    //public static final String ID = "ID";
    public static final String USERS_NAME = "Name";
    public static final String USERS_PWD = "Pwd";
    public static final String USERS_EMAIL = "Email";
    public static final String USER_PHONE = "Phone";
    private final Context context;



    private static final String CREATE_TABLE_USERS = " CREATE TABLE "
            + TABLE_USERS + "("
            + USERS_NAME + " TEXT, "
            + USERS_PWD + " TEXT, "
            + USERS_EMAIL + " TEXT,"
            + USER_PHONE + " TEXT"
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


    public void insertUser(UserDetails user) {
        ContentValues values = new ContentValues();
        values.put(HelperDB.USERS_NAME, user.getUSERS_NAME());
        values.put(HelperDB.USERS_PWD, user.getUSERS_PWD());
        values.put(HelperDB.USERS_EMAIL, user.getUSERS_EMAIL());
        values.put(HelperDB.USER_PHONE, user.getUSER_PHONE());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_USERS, null, values);
        db.close();
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_USERS, null);
        return res;
    }

}