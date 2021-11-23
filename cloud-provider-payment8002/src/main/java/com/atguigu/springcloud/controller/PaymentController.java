package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

/**
 * @auther konglingyang
 * @date 2021/11/20 22:24
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;


    @PostMapping("/payment/create")
    public CommonResult<Payment> createPayment(@RequestBody Payment payment) {

        Integer createResult = paymentService.createPayment(payment);
        log.info("**************插入结果为：{}", createResult);
        if (createResult != null && createResult > 0) {
            return new CommonResult<>(200, "添加成功, 端口号：" + serverPort, payment);
        } else {
            return new CommonResult<Payment>(444, "添加失败端口号：" + serverPort);
        }
    }

    @GetMapping("/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id) {

        Payment payment = paymentService.getPaymentById(id);
        log.info("========查询结果为：{}", payment);
        if (payment != null) {
            return new CommonResult<Payment>(200, "查询成功，端口号：" + serverPort, payment);
        } else {
            return new CommonResult<Payment>(444, "没有对应记录，端口号：" + serverPort);
        }

    }

    @GetMapping("/payment/discoveryClient")
    public Object discoveryClient() {

        List<String> services = discoveryClient.getServices();
        Iterator<String> iterator = services.iterator();
        while (iterator.hasNext()) {
            String next =  iterator.next();
            log.info("*******服务名称：{}",next);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" +
                    instance.getInstanceId() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymnetLB() {

        return serverPort;
    }
}
