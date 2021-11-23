package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @auther konglingyang
 * @date 2021/11/23 8:52
 */
public interface LoadBanlancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
