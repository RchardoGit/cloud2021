package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @auther konglingyang
 * @date 2021/11/24 9:01
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DashboardMain9001 {

        public static void main(String[] args) {
            SpringApplication.run(DashboardMain9001.class, args);
        }
}
