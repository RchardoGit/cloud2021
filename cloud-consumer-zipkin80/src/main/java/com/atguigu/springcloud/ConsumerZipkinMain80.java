package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @auther konglingyang
 * @date 2021/11/26 9:46
 */
@SpringBootApplication
@EnableEurekaClient
public class ConsumerZipkinMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerZipkinMain80.class, args);
    }
}
