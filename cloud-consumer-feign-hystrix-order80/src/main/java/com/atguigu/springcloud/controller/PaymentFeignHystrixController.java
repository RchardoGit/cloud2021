package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.service.OrderProviderHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @auther konglingyang
 * @date 2021/11/23 19:53
 */
@RestController
@DefaultProperties(defaultFallback = "payment_global_fallbackMethod")
public class PaymentFeignHystrixController {

    @Resource
    private OrderProviderHystrixService paymentService;

    @GetMapping(value = "/consumer/payment/getId_ok/{id}")
    public CommonResult<String> paymentHystrixOK(@PathVariable("id") Integer id) {
        return paymentService.paymentHystrixOK(id);
    }


//    @HystrixCommand(fallbackMethod = "paymentHystrixTimeOutInfo", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @GetMapping(value = "/consumer/payment/getId_timeout/{id}")
    @HystrixCommand
    public CommonResult<String> paymentHystrixTimeOut(@PathVariable("id") Integer id) {
        return paymentService.paymentHystrixTimeOut(id);
    }


    public CommonResult<String> paymentHystrixTimeOutInfo(@PathVariable("id") Integer id) {
       return new CommonResult<String>(444,"支付异常",
                "线程池：" + Thread.currentThread().getName() +
                        "hystrix_timeout,id " + id);
    }

    public  CommonResult<String> payment_global_fallbackMethod() {
        return new CommonResult<String>(444,"支付异常或超时，请稍后重试");
    }
}
