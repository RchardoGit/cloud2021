package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @auther konglingyang
 * @date 2021/11/27 9:44
 */
@RestController
public class OrderController {
    public static final String SERVER_URL = "http://cloudalibaba-provicer-payment";

    @Resource
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consumer/payment/getServerPort")
    public String getServerPort() {
        String result = restTemplate
                .getForObject(SERVER_URL + "/payment/getServerPort", String.class);
        return result + "consumerServerport:" + serverPort;
    }
}
