package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @auther konglingyang
 * @date 2021/11/21 19:58
 */
public interface PaymentService {

    Integer createPayment(Payment payment);

    Payment getPaymentById(Long id);
}
