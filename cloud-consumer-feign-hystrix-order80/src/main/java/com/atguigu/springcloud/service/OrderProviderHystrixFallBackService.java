package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.stereotype.Service;

/**
 * @auther konglingyang
 * @date 2021/11/23 21:41
 */
@Service
public class OrderProviderHystrixFallBackService implements OrderProviderHystrixService {
    @Override
    public CommonResult<String> paymentHystrixOK(Integer id) {
        return new CommonResult<String>(444,"paymentHystrixOK/(ㄒoㄒ)/~~");
    }

    @Override
    public CommonResult<String> paymentHystrixTimeOut(Integer id) {
        return new CommonResult<String>(444,"paymentHystrixTimeOut/(ㄒoㄒ)/~~");
    }
}
