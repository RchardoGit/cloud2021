package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @auther konglingyang
 * @date 2021/11/20 22:13
 */

public interface PaymentService {

    Integer createPayMent(Payment payment);

    Payment getPaymentById(@Param("id")Long id);
}
