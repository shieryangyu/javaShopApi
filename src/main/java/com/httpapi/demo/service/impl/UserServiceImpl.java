package com.httpapi.demo.service.impl;

import com.httpapi.demo.bean.ResultBean;
import com.httpapi.demo.dao.UserDao;
import com.httpapi.demo.service.UserService;
import com.httpapi.demo.util.MD5Utils;
import com.httpapi.demo.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.httpapi.demo.bean.User;
import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public ResultBean UserLogin(String phone, String pwd) {
        List<User> userList=userDao.UserLogin(phone, MD5Utils.encode(pwd));
        return userList.isEmpty() ? ResultUtil.Error("登陆失败") : ResultUtil.success(userList);
    }

    @Override
    public ResultBean addUser(String phone, String pwd, String nickname) {
        try{
            userDao.addUser(phone, MD5Utils.encode(pwd),nickname);
        }catch (Exception e){
            return  ResultUtil.Error(e.getMessage());
        }
        return  ResultUtil.success("null");
    }

    @Override
    public ResultBean setAddress(String truename, String address, int uid) {
        try{
            userDao.setAddress(truename,address,uid);
        }catch (Exception e){
            return ResultUtil.Error(e.getMessage());
        }
        return ResultUtil.success("null");
    }
}
