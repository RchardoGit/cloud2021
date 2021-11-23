package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @auther konglingyang
 * @date 2021/11/23 19:47
 */
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-SERVICE", fallback = OrderProviderHystrixFallBackService.class)
public interface OrderProviderHystrixService {

    @GetMapping(value = "/payment/getId_ok/{id}")
    CommonResult<String> paymentHystrixOK(@PathVariable("id") Integer id);

    @GetMapping(value = "/payment/getId_timeout/{id}")
    CommonResult<String> paymentHystrixTimeOut(@PathVariable("id") Integer id);

}
