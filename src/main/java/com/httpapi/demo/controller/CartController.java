package com.httpapi.demo.controller;

import com.httpapi.demo.bean.ResultBean;
import com.httpapi.demo.service.CartService;
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
@RequestMapping(value = "/cart",method = RequestMethod.POST)
public class CartController {

     @Autowired
    private CartService cartService;

    @RequestMapping(value = "/addCart",method = RequestMethod.POST)
    @ApiOperation(value=" 添加商品到购物车", notes=" 添加商品到购物车")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid ", value = "用户id", required = true, dataType = "String"),
            @ApiImplicitParam(name = "shopid ", value = "商品id", required = true, dataType = "String"),
    })
    public ResultBean addCart(@RequestBody Map<String, String> cart){
        return  cartService.addCart(Integer.parseInt(cart.get("userid")),Integer.parseInt(cart.get("shopid")));
    }


    @RequestMapping(value = "/selectCart",method = RequestMethod.POST)
    @ApiOperation(value=" 查找用户的购物车数据", notes=" 购物车页面需要的接口，查看用户购物车有多少商品，这里只需要userid参数即可")
    @ApiImplicitParam(name = "userid ", value = "用户id", required = true, dataType = "String")
    public ResultBean selectCart(@RequestBody Map<String, String> cart){
        return  cartService.selectCart(Integer.parseInt(cart.get("userid")));
    }


    @RequestMapping(value = "/checkCart",method = RequestMethod.POST)
    @ApiOperation(value=" 添加商品到购物车", notes=" 添加商品到购物车")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid ", value = "用户id", required = true, dataType = "String"),
            @ApiImplicitParam(name = "shopid ", value = "商品id", required = true, dataType = "String"),
    })
    public ResultBean checkCart(@RequestBody Map<String, String> cart){
        return  cartService.checkCart(Integer.parseInt(cart.get("userid")),Integer.parseInt(cart.get("shopid")));
    }


    @RequestMapping(value = "/deleteCart",method = RequestMethod.POST)
    @ApiOperation(value=" 用户删除购物车中某条商品时候使用", notes=" 用户删除购物车中某条商品时候使用")
    @ApiImplicitParam(name = "cid ", value = "购物车表的id", required = true, dataType = "String")
    public ResultBean deleteCart(@RequestBody Map<String, String> cart){
        return  cartService.deleteCart(Integer.parseInt(cart.get("cid")));
    }

}
