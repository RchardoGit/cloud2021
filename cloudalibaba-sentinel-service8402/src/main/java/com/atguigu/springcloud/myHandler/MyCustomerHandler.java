package com.atguigu.springcloud.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;

/**
 * @auther konglingyang
 * @date 2021/11/28 21:08
 */

public class MyCustomerHandler {

    public static CommonResult<Payment> handlerException(BlockException exception) {
        return new CommonResult<Payment>(444,"客户自定义调用失败 blockHandler1" );
    }

    public static CommonResult<Payment>  handlerException2(BlockException exception) {
        return new CommonResult<Payment>(444,"客户自定义调用失败 blockHandler2" );
    }
}
