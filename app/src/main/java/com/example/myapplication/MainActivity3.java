package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
//import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
//import android.text.Editable;
import android.view.View;
import android.widget.Button;
//import android.widget.CheckBox;
//import android.widget.CompoundButton;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {
    Button btretern;
    Button btReg;
    //CheckBox cShowpasword;
    UserDetails user = new UserDetails();
    EditText etRegName;
    EditText etRegEmail;
    EditText etRegPassword;
    EditText etRegPassword2;
    EditText etRegPhone;
    HelperDB helperDB = new HelperDB(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        etRegPassword = findViewById(R.id.etRegPassword);
        etRegPassword2 = findViewById(R.id.etRegPassword2);

        btReg = findViewById(R.id.btReg);
        btReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String namereg = etRegName.getText().toString();

                String emailreg = etRegEmail.getText().toString();

                String pasreg = etRegPassword.getText().toString();

                String pas2 = etRegPassword2.getText().toString();

                String phonreg = etRegPhone.getText().toString();

                if (IsValid(emailreg,pasreg,pas2,phonreg)) {

                    user.setUserName(etRegName.getText().toString());

                    user.setUserEmail(etRegEmail.getText().toString());

                    user.setUserPwd(etRegPassword.getText().toString());

                    user.setUserPwd(etRegPassword2.getText().toString());

                    user.setUserPhone(etRegPhone.getText().toString());

                    helperDB.insertUser(user);
                }
              //  else{}
                //notificaSHEN THET SOME THING IS ICORECT
            }



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
    public static boolean IsValid(String Email,String Password,String Password2,String Phone){
        //if (Name is in table){return false}

        if (!Email.contains("@") && !Email.contains(".com")) return false;
        if (!Password.equals(Password2)) return false;
        if (!(Phone.charAt(0) ==0) && !(Phone.charAt(1) ==5)) return false;
        return true;
    }


}