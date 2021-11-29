package com.atguigu.springcloud;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @auther konglingyang
 * @date 2021/11/28 19:34
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelMain8402 {

    public static void  main(String[] args) {
        SpringApplication.run(SentinelMain8402.class, args);
    }
}
