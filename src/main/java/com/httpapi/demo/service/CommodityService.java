package com.httpapi.demo.service;

import com.httpapi.demo.bean.Commodity;
import com.httpapi.demo.bean.ResultBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityService {
    ResultBean getAllCommodity(int pages);

    ResultBean getCommodityById(int id);

    ResultBean getCommodityByBrand(String brand);
}
