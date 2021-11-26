package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @auther konglingyang
 * @date 2021/11/26 9:34
 */
@EnableEurekaClient
@SpringBootApplication
public class ZipkinMain8901 {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinMain8901.class, args);
    }
}
