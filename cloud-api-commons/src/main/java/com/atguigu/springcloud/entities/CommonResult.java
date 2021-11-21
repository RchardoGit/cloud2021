package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @auther konglingyang
 * @date 2021/11/21 9:14
 * 订单返回信息类
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code,String message) {
        this(code,message,null);
    }

}
