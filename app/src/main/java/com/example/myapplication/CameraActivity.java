package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CameraActivity extends AppCompatActivity {
Button buttoncam;
ImageView imageViewcam;
ActivityResultLauncher<Intent> arSmale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        arSmale = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {

                    }
                }
        );
        CameraActivity.requestPermissions(this,

                new String[]{android.Manifest.permission.CAMERA,

                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE,

                        },

                1);

         buttoncam = findViewById(R.id.buttoncam);

    }

    private static void requestPermissions(CameraActivity cameraActivity, String[] strings, int i) {
    }


}