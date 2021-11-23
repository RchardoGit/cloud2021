package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBanlancer;
import javafx.geometry.HPos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @auther konglingyang
 * @date 2021/11/21 9:27
 */
@RestController
@Slf4j
public class OrderController {

    //private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";


    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBanlancer loadBanlancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {

        CommonResult commonResult = restTemplate
                .postForObject(PAYMENT_URL + "/payment/create/", payment, CommonResult.class);
        return commonResult;
    }

    @GetMapping(value = "/consumer/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id) {

        CommonResult commonResult = restTemplate
                .getForObject(PAYMENT_URL + "/payment/getPaymentById/" + id, CommonResult.class);
        return commonResult;

    }

    @GetMapping(value = "/consumer/payment/createByEntity")
    public CommonResult<Payment> create2(Payment payment) {
        ResponseEntity<CommonResult> commonResultEntity = restTemplate
                .postForEntity(PAYMENT_URL + "/payment/create/", payment, CommonResult.class);
        if(commonResultEntity.getStatusCode().is2xxSuccessful()) {
            return commonResultEntity.getBody();
        } else {
            return new CommonResult<Payment>(444,"添加失败");
        }
    }

    @GetMapping(value = "/consumer/payment/getPaymentByIdEntity/{id}")
    public CommonResult<Payment> getPaymentById2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL +
                "/payment/getPaymentById/" + id, CommonResult.class);

        if(forEntity.getStatusCode().is2xxSuccessful()) {
            return forEntity.getBody();
        } else {
            return new CommonResult<Payment>(444,"查无此人");
        }
    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient
                .getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance instance = loadBanlancer.instance(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb",String.class);

    }

}
