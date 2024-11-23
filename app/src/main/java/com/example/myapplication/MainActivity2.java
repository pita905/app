package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity  {
    Button btreg;
    Button btLog;
    Button btBack;
    EditText etEmailLogin;
    EditText etPasswordLogin;
    UserDetails user;
    HelperDB helperDB ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        etEmailLogin = findViewById(R.id.edPasswordLogin);
        btLog = findViewById(R.id.btLog);
        btLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailLogin = etEmailLogin.getText().toString();
                user.setUSERS_EMAIL(etEmailLogin.getText().toString());

                String emailLogin1 = etPasswordLogin.getText().toString();
                user.setUSERS_PWD(etPasswordLogin.getText().toString());
            }
        });

       btLog = findViewById(R.id.btLog);
       btLog.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Cursor res = helperDB.getAllData();
            if (res.getCount()==0){


                return;
            }
            else if (res.getString(2).equals(user.getUSERS_EMAIL()) && res.getString(1).equals(user.getUSERS_PWD())){
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
            else if (!(res.getString(2).equals(user.getUSERS_EMAIL()) && res.getString(1).equals(user.getUSERS_PWD()))){
               return;
            }

           }
       });


        btreg = findViewById(R.id.btreg);
        btreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });



        btBack = findViewById(R.id.btBack);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intent);
            }
        });
    }
}