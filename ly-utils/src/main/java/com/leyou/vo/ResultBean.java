package com.leyou.vo;

import com.leyou.exceptionenum.ExceptionEnum;
import lombok.Data;

@Data
public class ResultBean {

    private int code;
    private String message;

    public ResultBean(ExceptionEnum e){
        this.code = e.getStatus();
        this.message = e.getMessages();
    }

}
