package com.httpapi.demo.dao;

import com.httpapi.demo.bean.User;

import java.util.List;


public interface UserDao {
    List<User> UserLogin(String phone, String pwd);//登陆

    void addUser(String phone, String pwd, String nickname);//注册

    void setAddress(String truename, String address, int uid);//添加地址
}
