package com.httpapi.demo.controller;

import com.httpapi.demo.bean.ResultBean;
import com.httpapi.demo.service.OrderService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/order",method = RequestMethod.POST)
public class OrderController {

    @Autowired
    private OrderService orderService;


    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    @ApiOperation(value=" 提交订单", notes=" 提交订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "order ", value = "必须是一个数组，里面包含多个商品的对象", required = true, dataType = "String"),
            @ApiImplicitParam(name = "orderTotal ", value = "是前端购物车中计算的所有商品总价", required = true, dataType = "String"),
            @ApiImplicitParam(name = "money ", value = " 用户余额", required = true, dataType = "String"),
    })
    public ResultBean addOrder(@RequestBody Map<String, String> order){

        //{"uid":22 "sid":19 "total":8699 "size":"1"}
        //{"uid":22" sid":1" total":1199" size":"1"}
        return  orderService.addOrder(order.get("order"),order.get("orderTotal"),order.get("money"));
    }


    @RequestMapping(value = "/checkOrder",method = RequestMethod.POST)
    @ApiOperation(value=" 查看订单", notes=" 查看订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid ", value = "用户id", required = true, dataType = "String"),
            @ApiImplicitParam(name = "status ", value = "订单状态", required = true, dataType = "String"),
    })
    public ResultBean checkOrder(@RequestBody Map<String, String> order){
        return  orderService.checkOrder(Integer.parseInt(order.get("userid")),order.get("status"));
    }
}
