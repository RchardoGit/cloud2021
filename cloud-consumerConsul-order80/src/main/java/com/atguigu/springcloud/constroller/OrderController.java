package com.atguigu.springcloud.constroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @auther konglingyang
 * @date 2021/11/22 15:32
 */
@RestController
@Slf4j
public class OrderController {

    private static final String PAYMENT_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String paymentInfo() {

        String result = restTemplate
                .getForObject(PAYMENT_URL + "/payment/consul", String.class);
        return result;
    }
}
