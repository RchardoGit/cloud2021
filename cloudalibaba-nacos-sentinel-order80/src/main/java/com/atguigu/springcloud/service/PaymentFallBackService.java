package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @auther konglingyang
 * @date 2021/11/29 11:28
 */
@Component
public class PaymentFallBackService implements PaymentService {

    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        return new CommonResult<Payment>(4444,"获取失败=/(ㄒoㄒ)/~~");
    }

    @Override
    public CommonResult<Payment> createPayment(Payment payment) {
        return new CommonResult<Payment>(4444,"添加失败=/(ㄒoㄒ)/~~");
    }

}
