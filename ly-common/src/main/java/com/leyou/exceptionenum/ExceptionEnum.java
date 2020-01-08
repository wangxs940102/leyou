package com.leyou.exceptionenum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ExceptionEnum {
    Exception_Price_Cannot_Be_null(400,"您访问的页面被外星人劫持了")
    ;
    private int status;
    private String messages;

}
