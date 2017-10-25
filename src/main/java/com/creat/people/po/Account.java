package com.creat.people.po;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/31.
 */
public class Account implements Serializable{
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
