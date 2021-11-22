package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @auther konglingyang
 * @date 2021/11/22 14:21
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/consul")
    public String paymentConsul() {

        log.info("***********端口号：" + serverPort );
        return "springcloud with consul: " + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
