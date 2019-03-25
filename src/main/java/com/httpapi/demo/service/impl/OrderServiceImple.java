package com.httpapi.demo.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.httpapi.demo.bean.ResultBean;
import com.httpapi.demo.dao.OrderDao;
import com.httpapi.demo.service.OrderService;
import com.httpapi.demo.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("orderService")
public class OrderServiceImple implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public ResultBean addOrder(String order, String orderTotal, String money) {
        //{"uid":22 "sid":19 "total":8699 "size":"1"}
        //{"uid":22" sid":1" total":1199" size":"1"}

        String balance=String.valueOf(Integer.parseInt(money)-Integer.parseInt(orderTotal));
        List<HashMap> orderList= JSONArray.parseArray(order,HashMap.class);
        //获取当前毫秒数
        String number=String.valueOf(System.currentTimeMillis());
        //获取用户ID
        int userId= (int)(orderList.get(0).get("uid"));
        try{
            orderDao.addOrder(orderList,number);
            orderDao.deleteCartByUid(userId);
            orderDao.setMoney(balance,userId);
        }catch (Exception e){
            return ResultUtil.Error(e.getMessage());
        }
        return ResultUtil.success(number);
    }

    @Override
    public ResultBean checkOrder(int userid, String status) {
        List<HashMap<String,Object>> list = orderDao.checkOrder(userid,status);
        return list.isEmpty() ? ResultUtil.Error("订单为空") : ResultUtil.success(list);
    }
}
