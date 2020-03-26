package com.example.myapp.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myapp.R;

public class SendBroadcast extends AppCompatActivity {
    private static String TAG = "SendBroadcast";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_broadcast);
        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: 发送广播com.cds.broadcast.test");
                Intent send = new Intent("com.cds.broadcast.test");
                sendBroadcast(send);

                sendBroadcast(new Intent("com.example.broadcasttest.MY_BROADCAST"));
            }
        });
    }
}
