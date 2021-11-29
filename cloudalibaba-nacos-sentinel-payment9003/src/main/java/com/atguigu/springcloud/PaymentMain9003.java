package com.atguigu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @auther konglingyang
 * @date 2021/11/29 9:28
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.atguigu.springcloud.dao")
public class PaymentMain9003 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9003.class, args);
    }
}
