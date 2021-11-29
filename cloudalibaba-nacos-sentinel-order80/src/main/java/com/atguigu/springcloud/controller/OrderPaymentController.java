package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @auther konglingyang
 * @date 2021/11/29 11:32
 */
@RestController
@Slf4j
public class OrderPaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/order/payment/getById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }

    @GetMapping(value = "/order/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return paymentService.createPayment(payment);
    }
}
