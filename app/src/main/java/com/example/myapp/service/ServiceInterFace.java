package com.example.myapp.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapp.R;

public class ServiceInterFace extends AppCompatActivity implements View.OnClickListener {
    private static String TAG = "ServiceInterFace";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_layout);
        Log.d(TAG, "onCreate: 哈哈哈，欢迎来到服务的页面。");
        Button start = findViewById(R.id.start);
        Button stop = findViewById(R.id.stop);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start:
                // play music
                Log.d(TAG, "onClick: 点击了start按钮");
                Intent start = new Intent(this,MyService.class);
                startService(start);
                break;
            case R.id.stop:
                // stop music
                Log.d(TAG, "onClick: 点击了stop按钮");
                Intent stop = new Intent(this,MyService.class);
                stopService(stop);
                break;
            default:
                break;
        }
    }
}
