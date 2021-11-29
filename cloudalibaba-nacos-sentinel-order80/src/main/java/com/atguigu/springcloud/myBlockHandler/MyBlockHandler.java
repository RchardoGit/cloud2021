package com.atguigu.springcloud.myBlockHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;

/**
 * @auther konglingyang
 * @date 2021/11/29 11:37
 */
public class MyBlockHandler {

    public CommonResult<String> blockHandlerException(BlockException exception) {
        return new CommonResult<String>(4445,"blockException");
    }
}
