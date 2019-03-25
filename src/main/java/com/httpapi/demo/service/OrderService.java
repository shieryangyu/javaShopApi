package com.httpapi.demo.service;

import com.httpapi.demo.bean.ResultBean;

public interface OrderService {
    ResultBean addOrder(String order, String orderTotal, String money);

    ResultBean checkOrder(int userid, String status);
}
