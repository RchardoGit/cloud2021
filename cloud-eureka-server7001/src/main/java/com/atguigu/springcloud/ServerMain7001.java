package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @auther konglingyang
 * @date 2021/11/21 15:49
 */
@EnableEurekaServer
@SpringBootApplication
public class ServerMain7001 {

    public static void main(String[] args) {
        SpringApplication.run(ServerMain7001.class,args);
    }
}
