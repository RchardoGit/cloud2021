package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @auther konglingyang
 * @date 2021/11/29 11:23
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderNacosMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderNacosMain80.class, args);
    }
}
