package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity  {
    Button btreg;
    Button btLog;
    Button btBack;
    EditText etEmailLogin;
    EditText etPasswordLogin;
    HelperDB helperDB ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        etEmailLogin = findViewById(R.id.edPasswordLogin);

        //logiin in if user is in the database
        btLog = findViewById(R.id.btLog);
        btLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailLogin = etEmailLogin.getText().toString();
                String emailLogin1 = etPasswordLogin.getText().toString();

                UserDetails user = new UserDetails();
                user.setUSERS_PWD(etPasswordLogin.getText().toString());
                user.setUSERS_EMAIL(etEmailLogin.getText().toString());

                Cursor res = helperDB.getAllData();
           if (InData(res,user)){
              // Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
              // startActivity(intent);
               Toast.makeText(MainActivity2.this,
                       "congruts you are logged in", Toast.LENGTH_LONG).show();
           }
           else {Toast.makeText(MainActivity2.this,
                   "something is wrong,try writing correct email or password ", Toast.LENGTH_LONG).show();}
            }
            });

        //send user to register page
        btreg = findViewById(R.id.btreg);
        btreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });


        //send user to login page
        btBack = findViewById(R.id.btBack);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intent);
            }
        });
    }
    //check if user is in the database if not get notification on screen

    private boolean InData(Cursor res, UserDetails user) {
        if (res.getCount()==0){
            Toast.makeText(MainActivity2.this,
                    "something went wrong,try registering", Toast.LENGTH_LONG).show();
            return false;
        }
        else if (res.getString(2).equals(user.getUSERS_EMAIL()) && res.getString(1).equals(user.getUSERS_PWD())){
           return true;
        }
        else if (!(res.getString(2).equals(user.getUSERS_EMAIL()) && res.getString(1).equals(user.getUSERS_PWD()))){

return false;
        }

        return false;
    }
    }
