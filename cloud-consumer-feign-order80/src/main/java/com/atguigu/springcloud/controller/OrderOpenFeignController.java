package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.OrderOpenfeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @auther konglingyang
 * @date 2021/11/23 11:06
 */
@RestController
@Slf4j
public class OrderOpenFeignController {

    @Resource
    private OrderOpenfeignService orderOpenfeignService;

    @GetMapping(value = "/consumer/payment/getPayment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id) {
        return orderOpenfeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> createPayment(Payment payment) {
        log.info("*************************:" + payment.getSerial() );
        return orderOpenfeignService.createPayment(payment);
    }

    @GetMapping(value = "/consumer/payment/timeout")
    public String timeout() {
        return orderOpenfeignService.timeout();
    }

}
