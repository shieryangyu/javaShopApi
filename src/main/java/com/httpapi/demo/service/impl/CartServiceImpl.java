package com.httpapi.demo.service.impl;

import com.httpapi.demo.bean.ResultBean;
import com.httpapi.demo.dao.CartDao;
import com.httpapi.demo.service.CartService;
import com.httpapi.demo.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("cartService")
public class CartServiceImpl implements CartService {
     @Autowired
    private CartDao cartDao;

    @Override
    public ResultBean addCart(int userid, int shopid) {
        try{
            cartDao.addCart(userid,shopid);
        }catch (Exception e){
            return ResultUtil.Error(e.getMessage());
        }
        return ResultUtil.success("购物车添加成功");
    }


    @Override
    public ResultBean selectCart(int userid) {
        List<HashMap<String,Object>> cartList=cartDao.selectCart(userid);
        return cartList.isEmpty() ? ResultUtil.Error("购物车数据不存在") : ResultUtil.success(cartList);
    }

    @Override
    public ResultBean checkCart(int userid, int shopid) {

        List<HashMap<String,Object>> cartList = cartDao.checkCart(userid,shopid);

        return cartList.isEmpty() ? ResultUtil.Error("商品未添加") : ResultUtil.success(cartList);
    }

    @Override
    public ResultBean deleteCart(int cid) {
        try{
            cartDao.deleteCart(cid);
        }catch (Exception e){
            return ResultUtil.Error(e.getMessage());
        }
        return ResultUtil.success("购物车删除成功");
    }

}

