package com.example.myapp.listView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapp.R;

import java.util.ArrayList;
import java.util.List;

public class ListVIewLearner extends AppCompatActivity {

    private ListView muserInfo;
    private List<UserInfo> mUserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_v_iew_learner);
        // 找到ListView
        muserInfo = findViewById(R.id.show_all_user);

        // 构建一些数据
        mUserInfo = new ArrayList<UserInfo>();
        initArrayList((ArrayList<UserInfo>) mUserInfo);
        // 初始化适配器
        final ListViewAdapter listViewAdapter = new ListViewAdapter(ListVIewLearner.this,mUserInfo);
        // 将适配器和ListView绑定
        muserInfo.setAdapter(listViewAdapter);
        // 更新数据
        listViewAdapter.notifyDataSetChanged();


        // 设置item单击事件
        muserInfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    // 新建数据
                    updateArrayList((ArrayList<UserInfo>) mUserInfo);
                    // 替换旧数据
                    listViewAdapter.notifyDataSetChanged();
                    // 刷新页面
                }
                // 点击后弹出一个提醒
                Toast.makeText(ListVIewLearner.this,
                        "名字：" + mUserInfo.get(position).getName() + "-你被我点击了",
                        Toast.LENGTH_LONG).show();
            }
        });
        // 设置item长按事件
        muserInfo.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListVIewLearner.this,
                        "名字：" + mUserInfo.get(position).getName() + "-你被我长按了",
                        Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }

    // 初始化数据函数
    void initArrayList(ArrayList<UserInfo> mUserInfo){
        mUserInfo.add(new UserInfo("a:点击我刷新数据",123444));
        mUserInfo.add(new UserInfo("b",123444));
        mUserInfo.add(new UserInfo("c",123444));
        mUserInfo.add(new UserInfo("d",123444));
        mUserInfo.add(new UserInfo("e",123444));
        mUserInfo.add(new UserInfo("f",123444));
    }
    void updateArrayList(ArrayList<UserInfo> mUserInfo) {
        mUserInfo.clear();
        mUserInfo.add(new UserInfo("新数据1",123444));
        mUserInfo.add(new UserInfo("新数据2",123444));
        mUserInfo.add(new UserInfo("新数据3",123444));
        mUserInfo.add(new UserInfo("新数据4",123444));
    }
}
