package com.example.myapp.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class DynamicBroadcastReceiver extends BroadcastReceiver {

    private  static String TAG = "动态广播";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: 动态广播收到了");
        throw new UnsupportedOperationException("Not yet implemented");

    }
}
