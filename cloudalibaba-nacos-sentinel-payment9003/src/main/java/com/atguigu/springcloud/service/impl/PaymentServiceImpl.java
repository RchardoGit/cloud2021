package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @auther konglingyang
 * @date 2021/11/29 9:47
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentDao, Payment> implements PaymentService {


}
