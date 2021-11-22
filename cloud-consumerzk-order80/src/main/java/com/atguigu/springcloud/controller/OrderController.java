package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @auther konglingyang
 * @date 2021/11/22 11:01
 */
@RestController
@Slf4j
public class OrderController {

    private static final String PAYMENT_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String paymentInfo() {

        String result = restTemplate
                .getForObject(PAYMENT_URL + "/payment/zk", String.class);
        return result;
    }
}
