package com.example.myapp.listView;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private String name;
    private int phone;

    public UserInfo(String name, int phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", age=" + phone +
                '}';
    }
}
