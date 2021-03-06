package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @auther konglingyang
 * @date 2021/11/23 11:00
 */

@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface OrderOpenfeignService {

    @GetMapping(value = "/payment/getPaymentById/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id")Long id);

    @PostMapping(value = "/payment/create")
    CommonResult<Payment> createPayment(@RequestBody Payment payment);

    @GetMapping(value = "/payment/timeout")
    String timeout();

}
