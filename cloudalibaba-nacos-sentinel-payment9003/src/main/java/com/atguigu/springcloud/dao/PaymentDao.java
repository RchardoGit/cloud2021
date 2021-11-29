package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @auther konglingyang
 * @date 2021/11/29 9:42
 */

public interface PaymentDao extends BaseMapper<Payment> {
}
