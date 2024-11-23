package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import java.text.BreakIterator;

public class MainActivity2 extends AppCompatActivity  {
    Button btreg;
    Button btLog;
    Button btBack;
    EditText etEmailLogin;
    EditText etPasswordLogin;
    UserDetails user;
    HelperDB helperDB = new HelperDB(this);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        etEmailLogin = findViewById(R.id.etEmailLogin);
        btLog = findViewById(R.id.btLog);
        btLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailLogin = etEmailLogin.getText().toString();
                user.setUserEmail(etEmailLogin.getText().toString());

                String emailLogin1 = etPasswordLogin.getText().toString();
                user.setUserPwd(etPasswordLogin.getText().toString());
            }
        });

       btLog = findViewById(R.id.btLog);
       btLog.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Cursor res = helperDB.getAllData();
            if (res.getCount()==0){
           //show message
           return;
            }
            else if (res.getString(2).equals(user.getUserEmail()) && res.getString(1).equals(user.getUserPwd())){
             //   Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
             //   startActivity(intent);
            }
            else{
                //show message
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