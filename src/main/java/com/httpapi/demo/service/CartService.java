package com.httpapi.demo.service;

import com.httpapi.demo.bean.ResultBean;

public interface CartService {

    ResultBean addCart(int userid, int shopid);

    ResultBean selectCart(int userid);

    ResultBean checkCart(int userid, int shopid);

    ResultBean deleteCart(int cid);
}
