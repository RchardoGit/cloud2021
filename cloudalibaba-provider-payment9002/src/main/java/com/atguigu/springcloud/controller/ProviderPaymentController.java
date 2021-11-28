package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther konglingyang
 * @date 2021/11/27 9:08
 */
@RestController
public class ProviderPaymentController {

    @Value("${server.port}")
    private String servrPort;

    @GetMapping("/payment/getServerPort")
    public String getServrPort() {
        return servrPort;
    }
}
