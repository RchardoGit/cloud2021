package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @auther konglingyang
 * @date 2021/11/21 17:10
 */
@EnableEurekaServer
@SpringBootApplication
public class Server7002Main {

    public static void main(String[] args) {
        SpringApplication.run(Server7002Main.class, args);
    }
}
