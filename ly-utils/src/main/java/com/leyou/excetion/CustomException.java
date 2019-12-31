package com.leyou.excetion;

import com.leyou.exceptionenum.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import sun.rmi.runtime.Log;


/**
 *
 * 通用异常处理类
 * 引入枚举
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CustomException extends RuntimeException {
    private ExceptionEnum exceptionEnum;
}
