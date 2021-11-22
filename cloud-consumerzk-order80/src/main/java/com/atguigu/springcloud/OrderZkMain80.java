package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @auther konglingyang
 * @date 2021/11/22 10:58
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderZkMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderZkMain80.class, args);
    }
}
