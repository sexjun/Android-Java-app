package com.example.myapp.handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp.R;

public class HandlerLeaner extends AppCompatActivity {
    private  static final String TAG = HandlerLeaner.class.getSimpleName();
    private int mMESSGE_code;
    private Button mButton;
    private TextView mTextview;
    public  static final  int MESSGE_CODE = 10000;
    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            Log.d(TAG, "handleMessage: 进来了handleMessage");
            switch (msg.what){
                case MESSGE_CODE:
                    Log.d(TAG, "handleMessage: 进入switch");
                    Integer value = (Integer)msg.obj;
                    if (value == null) {
                        Log.d(TAG, "handleMessage: value == null ");
                        Log.d(TAG, "handleMessage: " + value);
                    } else {
                        Log.d(TAG, "handleMessage: value ==  " + value);
                    }
                    mTextview.setText(String.valueOf(value/1000));

                    msg = Message.obtain();
                    msg.what = MESSGE_CODE;
                    msg.obj = value - 1000;
                    if (value > 0) {
                        sendMessageDelayed(msg,1000);
                    }
                    break;
                default:
                    Log.d(TAG, "handleMessage: 进入了default");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_leaner);
        mTextview = findViewById(R.id.aaa);
        mButton = findViewById(R.id.id_button_handler_01);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HandlerLeaner.this, "延迟一秒开始倒计时 ",
                        Toast.LENGTH_SHORT).show();

                Message message =mHandler.obtainMessage();
                message.arg1 = 1000;
                message.what = MESSGE_CODE;
                message.obj = 10000;
                mHandler.sendMessageDelayed(message, 1000);
            }
        });


    }
}
