package com.atguigu.springcloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
//import com.atguigu.springcloud.myBlockHandler.MyblockHandler;
import com.atguigu.springcloud.myBlockHandler.MyBlockHandler;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @auther konglingyang
 * @date 2021/11/29 11:25
 */

@FeignClient(value = "nacos-sentinel-payment", fallback = PaymentFallBackService.class)
public interface PaymentService {

    @GetMapping(value = "/payment/getById/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id")Long id);

    @PostMapping(value = "/payment/create")
    CommonResult<Payment> createPayment(@RequestBody Payment payment);
}
