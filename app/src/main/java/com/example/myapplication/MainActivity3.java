package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
//import android.text.Editable;
import android.view.View;
import android.widget.Button;
//import android.widget.CheckBox;
//import android.widget.CompoundButton;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {
    Button btretern;
    Button btReg;
    CheckBox cShowpasword;
    EditText etRegName;
    EditText etRegEmail;
    EditText etRegPassword;
    EditText etRegPassword2;
    EditText etRegPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        HelperDB helperDB= new HelperDB(this);
      //  SQLiteDatabase db;

        etRegName = findViewById(R.id.etRegName);
        etRegEmail = findViewById(R.id.etRegEmail);
        etRegPhone = findViewById(R.id.etRegPhone);
        etRegPassword = findViewById(R.id.etRegPassword);
        etRegPassword2 = findViewById(R.id.etRegPassword2);
//register new user
        btReg = findViewById(R.id.btReg);
        btReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String namereg = etRegName.getText().toString().trim();

                String emailreg = etRegEmail.getText().toString().trim();

                String pasreg = etRegPassword.getText().toString().trim();

                String pas2 = etRegPassword2.getText().toString().trim();

                String phonreg = etRegPhone.getText().toString().trim();

                if (!IsValid(emailreg,pasreg,pas2,phonreg)) {
                    Intent intent = new Intent(MainActivity3.this, MainActivity3.class);
                    startActivity(intent);

                }
                UserDetails user = new UserDetails(pasreg,namereg, emailreg, phonreg);
                helperDB.insertUser(user);

                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(intent);

            }


//go back to login page
        });
        btretern = findViewById(R.id.btretern);
        btretern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(intent);
            }
        });

    }
    //check if user data is valid
    public static boolean IsValid(String Email,String Password,String Password2,String Phone){
        //if (Name is in table){return false}

        if (!Email.contains("@") && !Email.contains(".com")) return false;
        if (!Password.equals(Password2)) return false;
     //   if (!(Phone.charAt(0) ==0) && !(Phone.charAt(1) ==5)) return false;
        return true;
    }


}