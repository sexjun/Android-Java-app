package com.example.myapp.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class StaticMyBroadcastReceiver extends BroadcastReceiver {
    private static String TAG = " MyBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: 欢迎进入广播接收界面");
        StringBuilder sb = new StringBuilder();
        sb.append("action" + intent.getAction() + "\n");
        sb.append("URI" + intent.toUri(Intent.URI_INTENT_SCHEME).toString() + "\n");
        String log = sb.toString();
        Log.d(TAG, log);
        Toast.makeText(context,log,Toast.LENGTH_SHORT).show();
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
