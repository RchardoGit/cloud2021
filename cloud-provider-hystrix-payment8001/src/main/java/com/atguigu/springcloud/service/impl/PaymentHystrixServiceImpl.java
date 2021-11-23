package com.atguigu.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @auther konglingyang
 * @date 2021/11/23 17:08
 */
@Service
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public CommonResult<String> hystrix_ok(Integer id) {

        return new CommonResult<String>(200,"调用成功",
                "线程池：" + Thread.currentThread().getName() + "hystrix_ok,id  " + id );
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    public CommonResult<String> hystrix_timeout(Integer id) {
        int sleepTime = 2;
        try {
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult<String>(200,"调用成功",
                "线程池：" + Thread.currentThread().getName() +
                        "hystrix_timeout,id  " + id + "超时时间：" + sleepTime);
    }


    public CommonResult<String> paymentInfo_TimeOutHandler(Integer id) {

        return new CommonResult<String>(444,"调用接口超时或异常",
                "线程池：" + Thread.currentThread().getName() +
                        "hystrix_timeout,id " + id);
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallBack",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  /*// 是否开启断路器*/
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),  /*// 请求次数*/
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  /*// 时间窗口期*/
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")  // 失败率达到多少跳闸
    })
    public CommonResult<String> paymentCircuitBreaker(Integer id) {
        if(id<0) {
            throw new RuntimeException("id不能为负数");
        }
        String serialNunber = IdUtil.simpleUUID();

        return new CommonResult<String>(200,"调用成功，流水号：" + serialNunber);
    }

    public CommonResult<String> paymentCircuitBreakerFallBack(Integer id) {

        return new CommonResult<String>(444,"id不能为负数/(ㄒoㄒ)/~~");
    }
}
