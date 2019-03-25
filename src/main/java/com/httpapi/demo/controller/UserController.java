package com.httpapi.demo.controller;

import com.httpapi.demo.bean.ResultBean;
import com.httpapi.demo.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/user",method = RequestMethod.POST)
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value="根据账户密码实现用户登陆", notes="根据账户密码实现用户登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pwd", value = "密码", required = true, dataType = "String")
    })
    public ResultBean UserLogin(@RequestBody Map<String,String> user){
        return  userService.UserLogin(user.get("phone"), user.get("pwd"));
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ApiOperation(value="注册一个新账号", notes="注册一个新账号")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pwd", value = "用户密码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "nickname", value = "昵称(显示在我的页面上)", required = true, dataType = "String")
    })
    public ResultBean addUser(@RequestBody Map<String,String> user){
        return  userService.addUser(user.get("phone"), user.get("pwd"),user.get("nickname"));
    }


    @RequestMapping(value = "/setAddress",method = RequestMethod.POST)
    @ApiOperation(value=" 保存用户收货地址", notes=" 保存用户收货地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "truename", value = "用户真实姓名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "address ", value = "收货地址", required = true, dataType = "String"),
            @ApiImplicitParam(name = "uid", value = "用户id", required = true, dataType = "String")
    })
    public ResultBean setAddress(@RequestBody Map<String, String> user){
        return  userService.setAddress(user.get("truename"), user.get("address"),Integer.parseInt(user.get("uid")));
    }

}
