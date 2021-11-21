package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @auther konglingyang
 * @date 2021/11/21 19:56
 */
@EnableEurekaClient
@SpringBootApplication
public class Payment8002Main {

    public static void main(String[] args) {
        SpringApplication.run(Payment8002Main.class, args);
    }
}
