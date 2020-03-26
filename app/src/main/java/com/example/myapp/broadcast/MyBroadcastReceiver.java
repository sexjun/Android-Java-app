package com.example.myapp.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    private static String TAG = " MyBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"收到了广播",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onReceive: 收到了广播");
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
