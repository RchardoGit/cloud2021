package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @auther konglingyang
 * @date 2021/11/24 20:01
 */
@SpringBootApplication
@EnableEurekaClient
public class ClientMain3355 {

    public static void main(String[] args) {
        SpringApplication.run(ClientMain3355.class, args);
    }
}
