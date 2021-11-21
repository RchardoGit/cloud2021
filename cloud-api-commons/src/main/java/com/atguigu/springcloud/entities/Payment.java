package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @auther konglingyang
 * @date 2021/11/21 9:12
 * 订单实体类
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment implements Serializable {

    private Long id;
    private String serial;

}
