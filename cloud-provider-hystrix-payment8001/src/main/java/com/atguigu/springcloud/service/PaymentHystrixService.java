package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;

/**
 * @auther konglingyang
 * @date 2021/11/23 17:06
 */
public interface PaymentHystrixService {

    CommonResult<String> hystrix_ok(Integer id);

    CommonResult<String> hystrix_timeout(Integer id);

    CommonResult<String> paymentCircuitBreaker(Integer id);

}
