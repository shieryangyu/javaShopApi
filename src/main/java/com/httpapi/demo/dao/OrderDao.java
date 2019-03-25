package com.httpapi.demo.dao;

import java.util.HashMap;
import java.util.List;

public interface OrderDao {
    void addOrder(List<HashMap> orderList,String number);

    void setMoney(String balance,int userId);

    void deleteCartByUid(int userId);

    List<HashMap<String, Object>> checkOrder(int userid, String status);
}
