package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @auther konglingyang
 * @date 2021/11/25 15:00
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitmqMain8801 {

    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitmqMain8801.class, args);
    }
}
