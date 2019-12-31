package com.leyou.advice;

import com.leyou.exceptionenum.ExceptionEnum;
import com.leyou.excetion.CustomException;
import com.leyou.vo.ResultBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 拦截所有controller
 */
@ControllerAdvice
public class ExceptionAdvice extends RuntimeException {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ResultBean> saveExceptionAdvice(CustomException e){
        ExceptionEnum exceptionEnum = e.getExceptionEnum();
        return ResponseEntity.status(e.getExceptionEnum().getStatus()).body(new ResultBean(e.getExceptionEnum()));
    }
}
