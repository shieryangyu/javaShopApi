package com.httpapi.demo.service.impl;

import com.httpapi.demo.bean.Commodity;
import com.httpapi.demo.bean.ResultBean;
import com.httpapi.demo.dao.CommodityDao;
import com.httpapi.demo.service.CommodityService;
import com.httpapi.demo.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityDao commodityDao;

    @Override
    public ResultBean getAllCommodity(int pages) {
        int page=(pages-1)*10;
        List<Commodity> commodityList=commodityDao.getAllCommodity(page);
        return commodityList.isEmpty() ? ResultUtil.Error("数据为空") : ResultUtil.success(commodityList);
    }

    @Override
    public ResultBean getCommodityById(int id) {
        List<Commodity> commodityList=commodityDao.getCommodityById(id);
        return commodityList.isEmpty() ? ResultUtil.Error("数据为空") : ResultUtil.success(commodityList);
    }

    @Override
    public ResultBean getCommodityByBrand(String brand) {
        List<Commodity> commodityList=commodityDao.getCommodityByBrand(brand);
        return commodityList.isEmpty() ? ResultUtil.Error("数据为空") : ResultUtil.success(commodityList);
    }
}
