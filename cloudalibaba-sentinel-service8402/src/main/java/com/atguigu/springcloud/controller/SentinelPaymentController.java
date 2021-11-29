package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.myHandler.MyCustomerHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther konglingyang
 * @date 2021/11/28 19:36
 */
@RestController
@Slf4j
public class SentinelPaymentController {


    @GetMapping(value = "/payment/testPayment")
    @SentinelResource(value = "testPayment", blockHandler = "deal_testPayment")
    public CommonResult<Payment> testPayment() {

        return new CommonResult<Payment>(200,"调用成功", new Payment(1L, "NB"));
    }

    public CommonResult<Payment> deal_testPayment(BlockException exception) {

        return new CommonResult<Payment>(444, "调用失败/(ㄒoㄒ)/~~" + exception.getClass().getName());
    }


    @GetMapping(value = "/payment/testPayment2")
    //@SentinelResource(value = "testPayment2")
    public CommonResult<Payment> testPayment2() {

        return new CommonResult<Payment>(200,"调用成功", new Payment(2L, "SB"));
    }

    @GetMapping(value = "/test/testResource")
    @SentinelResource( value = "testResource",
            blockHandlerClass = MyCustomerHandler.class,
            blockHandler = "handlerException2")
    public CommonResult<Payment> testResource() {

        return new CommonResult<Payment>(200,"按客户自定义 调用成功", new Payment(2L, "testResource"));
    }

}
