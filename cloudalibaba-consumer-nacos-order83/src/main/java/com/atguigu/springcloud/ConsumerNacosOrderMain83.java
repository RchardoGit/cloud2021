package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @auther konglingyang
 * @date 2021/11/27 9:25
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerNacosOrderMain83 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerNacosOrderMain83.class, args);
    }
}
