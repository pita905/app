package com.example.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextToSpeechHelper ttsh;

    private TextView textView;
    private Button btStart;
    private CountDownTimer countDownTimer;
    private boolean text;


    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id ==R.id.closeapp){
            finishAffinity(); // This will close all activities
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        btStart = findViewById(R.id.btStart);
        ttsh = new TextToSpeechHelper();
        Intent TTSService = new Intent(this.getApplicationContext(), TTSservis.class);

        TTSService.putExtra("text", text);

        startService(TTSService);
        ttsh.initTextToSpeech(this.getApplicationContext());
        countDownTimer = new CountDownTimer(10000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                String stCountDown = millisUntilFinished / 1000 + "";
                textView.setText(String.valueOf(stCountDown));
            }

            @Override
            public void onFinish() {
                textView.setText("FINISH!!");
            }
        };

        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
                countDownTimer.start();

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}