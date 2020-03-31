package com.example.myapp.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myapp.R;

public class SendBroadcast extends AppCompatActivity {
    private static String TAG = "SendBroadcast";
    private DynamicBroadcastReceiver mDynamicBroadcastReceiver;
    private IntentFilter mIntentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_broadcast);
        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendStaticBroadcodst();
                sendDynamicBroadcost();
            }
        });
    }

    private void sendStaticBroadcodst() {
        Log.d(TAG, "onClick: 发送广播com.example.broadcast.MY_NOTIFICATION");
        Intent intent = new Intent();
        intent.setAction("com.example.MyApp.MY_NOTIFICATION");
        intent.putExtra("data", "naic to see me ");
        sendBroadcast(intent);
    }

    private void sendDynamicBroadcost(){
        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction("com.example.MyApp.fromeCds");
        mDynamicBroadcastReceiver = new DynamicBroadcastReceiver();
        registerReceiver(mDynamicBroadcastReceiver, mIntentFilter);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mDynamicBroadcastReceiver);
    }
}
