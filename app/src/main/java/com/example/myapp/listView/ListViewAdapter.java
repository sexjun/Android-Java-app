package com.example.myapp.listView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapp.R;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<UserInfo> mUserInfos;
    public ListViewAdapter(Context context, List<UserInfo> userInfos) {
        mContext = context;
        mUserInfos = userInfos;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    // 数据量
    public int getCount() {
        return mUserInfos.size();
    }

    @Override
    // 某一条数据
    public Object getItem(int position) {
        return mUserInfos.get(position);
    }

    @Override
    //
    public long getItemId(int position) {
        return position;
    }

    @Override
    // 返回一个视图
    public View getView(int position, View convertView, ViewGroup parent) {
        // 新建viewHolder
        viewHolder viewHolderObject;

        if (convertView ==null){
            // 加载布局
            convertView = mLayoutInflater.inflate(R.layout.item_user_info,null);
            // 新建一个视图对象
            viewHolderObject = new viewHolder();
            // 在布局中找到文本控件
            viewHolderObject.userHeadImage = convertView.findViewById(R.id.ImageView_avatar);
            viewHolderObject.userName = convertView.findViewById(R.id.TextView_name);
            viewHolderObject.userPhone = convertView.findViewById(R.id.TextView_phone);
            // 存入布局
            convertView.setTag(viewHolderObject);
        }else {
            viewHolderObject = (viewHolder)convertView.getTag();
        }

        // 将数据与控件绑定
      viewHolderObject.userHeadImage.setImageResource(R.drawable.ic_launcher_foreground);
      viewHolderObject.userName.setText(mUserInfos.get(position).getName());
      viewHolderObject.userPhone.setText(String.valueOf(mUserInfos.get(position).getPhone()));
        // 返回布局
        return convertView;
    }
    /**
     * 保存视图的类
     */
    class viewHolder{
        ImageView userHeadImage;
        TextView userName;
        TextView userPhone;

    }
}
