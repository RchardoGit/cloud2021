package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @auther konglingyang
 * @date 2021/11/29 9:52
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;


    @GetMapping(value = "/payment/getById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id) {

        Payment payment = paymentService.getById(id);
        return new CommonResult<Payment>(200,"获取成功" +"\t" + serverPort, payment);
    }

    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> createPayment(Payment payment) {

        boolean save = paymentService.save(payment);
        if(payment == null) {
            throw new RuntimeException("payment不能为null");
        }
        if(!save) {
            return new CommonResult<Payment>(444,"保存失败"+"\t" + serverPort, payment);
        }
        return new CommonResult<Payment>(200,"保存成功:"+"\t" + serverPort, payment);
    }
}
