package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @auther konglingyang
 * @date 2021/11/22 10:59
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced  // 负载均衡
    public RestTemplate getRestTemplate() {

        return new RestTemplate();
    }
}
