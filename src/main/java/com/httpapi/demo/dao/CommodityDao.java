package com.httpapi.demo.dao;

import com.httpapi.demo.bean.Commodity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityDao {
    List<Commodity> getAllCommodity(int page);

    List<Commodity> getCommodityById(int id);

    List<Commodity> getCommodityByBrand(String brand);
}
