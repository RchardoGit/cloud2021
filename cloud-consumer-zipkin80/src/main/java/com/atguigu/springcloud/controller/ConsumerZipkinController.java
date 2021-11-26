package com.atguigu.springcloud.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @auther konglingyang
 * @date 2021/11/26 9:48
 */
@RestController
public class ConsumerZipkinController {

    private static final String ZIPKIN_URL = "http://CLOUD-PROVIDER-ZIPKIN";


    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/testZipkin")
    public String create() {

        String result = restTemplate
                .getForObject(ZIPKIN_URL + "/testZipkin",String.class);
        return result;
    }
}
