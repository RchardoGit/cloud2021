package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther konglingyang
 * @date 2021/11/23 17:15
 */
@RestController
@Slf4j
public class PaymentHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/getId_ok/{id}")
    public CommonResult<String> paymentHystrixOK(@PathVariable("id") Integer id) {
        CommonResult<String> stringCommonResult = paymentHystrixService.hystrix_ok(id);
        String message = stringCommonResult.getMessage();
        stringCommonResult.setMessage(message + "\t" + serverPort);
        return stringCommonResult;
    }

    @GetMapping(value = "/payment/getId_timeout/{id}")
    public CommonResult<String> paymentHystrixTimeOut(@PathVariable("id") Integer id) {
        CommonResult<String> stringCommonResult = paymentHystrixService.hystrix_timeout(id);
        String message = stringCommonResult.getMessage();
        stringCommonResult.setMessage(message + " " + serverPort);
        return stringCommonResult;
    }

    @GetMapping(value = "/payment/circuitBreaker/{id}")
    public CommonResult<String> paymentCircuitBreaker(@PathVariable("id")Integer id) {
        CommonResult<String> stringCommonResult = paymentHystrixService.paymentCircuitBreaker(id);
        return stringCommonResult;
    }

}
