package com.atguigu.springcloud;

import java.time.ZonedDateTime;

/**
 * @auther konglingyang
 * @date 2021/11/24 14:07
 */
public class DataTimeNow {

    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }
}
