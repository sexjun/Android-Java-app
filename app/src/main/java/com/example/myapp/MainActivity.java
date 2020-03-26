package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapp.handler.HandlerLeaner;
import com.example.myapp.listView.ListVIewLearner;
import com.example.myapp.service.MyService;
import com.example.myapp.service.ServiceInterFace;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "main activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // listview学习界面
        Button listView = findViewById(R.id.list_view);
        listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toListView = new Intent(MainActivity.this, ListVIewLearner.class);
                startActivity(toListView);
            }
        });

        // handle学习界面
        Button handler = findViewById(R.id.handler_Learner);
        handler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toHandler = new Intent(MainActivity.this, HandlerLeaner.class);
                startActivity(toHandler);
            }
        });

        //service学习界面
        Button service = findViewById(R.id.service_leaner);
        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: 我要去往service的界面的");
                Intent toService = new Intent(MainActivity.this, ServiceInterFace.class);
                startActivity(toService);
            }
        });

        //broadcost学习界面
        Button broadcost = findViewById(R.id.button_bradcast);
        broadcost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: 我要去broadcast学习界面");
                Intent toBroastCast = new Intent();
                startActivity(toBroastCast);
            }
        });

    }
}
