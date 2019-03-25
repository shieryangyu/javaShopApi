package com.httpapi.demo.dao;

import java.util.HashMap;
import java.util.List;

public interface CartDao {
    void addCart(int userid, int shopid);

    List<HashMap<String,Object>> selectCart(int userid);

    List<HashMap<String,Object>> checkCart(int userid, int shopid);

    void deleteCart(int cid);
}
