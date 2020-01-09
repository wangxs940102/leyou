package com.leyou.exceptionenum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 自定义枚举
 * 枚举对象数固定类似于单例
 * 该枚举用来定义响应状态码及相应信息
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ExceptionEnum {

    Exception_Categroy_Not_Find(404,"商品分离信息不存在"),
    EXCEPTION_Brand_IS_NULL(404,"未查询到品牌信息");
    ;
    private int status;
    private String messages;

}
