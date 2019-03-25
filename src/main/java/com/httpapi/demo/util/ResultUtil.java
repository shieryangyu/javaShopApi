package com.httpapi.demo.util;

import com.httpapi.demo.bean.ResultBean;

public class ResultUtil {
    public static ResultBean success(Object par){
        ResultBean resultBean=new ResultBean();
        resultBean.setMessage("null");
        resultBean.setStatus(200);
        resultBean.setData(par);
        return resultBean;
    }

    public static ResultBean Error(String message){
        ResultBean resultBean=new ResultBean();
        resultBean.setMessage(message);
        resultBean.setStatus(404);
        resultBean.setData(null);
        return resultBean;
    }
}
