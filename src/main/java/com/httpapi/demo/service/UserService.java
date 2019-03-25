package com.httpapi.demo.service;

import com.httpapi.demo.bean.ResultBean;

public interface UserService {
    ResultBean UserLogin(String phone, String pwd);

    ResultBean addUser(String phone, String pwd, String nickname);

    ResultBean setAddress(String truename, String address, int uid);
}
