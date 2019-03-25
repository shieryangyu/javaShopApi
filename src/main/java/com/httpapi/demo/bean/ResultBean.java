package com.httpapi.demo.bean;

import lombok.Getter;
import lombok.Setter;
import org.omg.CORBA.ObjectHelper;

@Getter
@Setter
public class ResultBean {
    private int status;
    private String message;
    private Object data;
}
