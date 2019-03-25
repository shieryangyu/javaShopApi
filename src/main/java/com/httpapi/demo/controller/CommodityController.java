package com.httpapi.demo.controller;

import com.httpapi.demo.bean.Commodity;
import com.httpapi.demo.bean.ResultBean;
import com.httpapi.demo.service.CommodityService;
import com.httpapi.demo.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/shop",method = RequestMethod.GET)
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @RequestMapping(value = "/ShowCommodity",method = RequestMethod.GET)
    @ApiOperation(value="根据不同页码显示", notes="根据不同页码显示")
    @ApiImplicitParam(name = "pages", value = "页数", required = true, dataType = "int",paramType = "query")
    public ResultBean ShowCommodity(@RequestParam(value = "pages",required = true,defaultValue = "1")int pages){
        return  commodityService.getAllCommodity(pages);
    }

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    @ApiOperation(value="根据不同的id获取不同信息", notes="根据不同的id获取不同信息")
    @ApiImplicitParam(name = "id", value = "商品的id", required = true, dataType = "int",paramType = "query")
    public ResultBean getCommodityById(@RequestParam(value = "id",required = true)int id){
        return  commodityService.getCommodityById(id);
    }

    @RequestMapping(value = "/class",method = RequestMethod.GET)
    @ApiOperation(value="根据品牌分类获取参数", notes="根据品牌分类获取参数")
    @ApiImplicitParam(name = "brand", value = "商品的品牌", required = true, dataType = "String",paramType = "query")
    public ResultBean getCommodityByBrand(@RequestParam(value = "brand",required = true)String brand){
        return  commodityService.getCommodityByBrand(brand);
    }
}
