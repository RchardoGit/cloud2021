package com.atguigu.springcloud;

//import com.atguigu.myRule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @auther konglingyang
 * @date 2021/11/21 9:08
 * 消费者订单Module主启动
 */
@EnableEurekaClient
@SpringBootApplication
public class OrderMain80 {

    public static void main(String[] args) {

        SpringApplication.run(OrderMain80.class,args);
    }
}
