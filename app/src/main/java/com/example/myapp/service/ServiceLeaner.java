package com.example.myapp.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.nfc.Tag;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import com.example.myapp.R;

public class ServiceLeaner extends Service implements View.OnClickListener{
    private static final String TAG = ServiceLeaner.class.getSimpleName();
    private MediaPlayer mMediaPlayer;
    public ServiceLeaner() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
        mMediaPlayer = MediaPlayer.create(this,R.raw.qi);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mMediaPlayer.start();
        int i = super.onStartCommand(intent, flags, startId);
        return i;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMediaPlayer.stop();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start:
                // play music
                break;
            case R.id.stop:
                // stop music
                break;
            default:
                break;
        }
    }
}
