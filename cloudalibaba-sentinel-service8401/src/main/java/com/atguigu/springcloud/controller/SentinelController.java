package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import jdk.nashorn.internal.ir.CallNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther konglingyang
 * @date 2021/11/28 9:52
 */
@RestController
@Slf4j
public class SentinelController {

    @GetMapping(value = "/testA")
    public String testA() {
        return "***********testA";
    }

    @GetMapping(value = "/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "****testB");
        return "***********testB";
    }

    @GetMapping(value = "/testD")
    public String testD() {

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info(Thread.currentThread().getName() + "\t" + "****testD");
        return "***********testD";
    }

    @GetMapping(value = "/testC")
    public String testC() {

        int i = 10/0;
        log.info(Thread.currentThread().getName() + "\t" + "****testC");
        return "***********testC";
    }

    @GetMapping(value = "/testE")
    public String testE() {

        int i = 10/0;
        log.info(Thread.currentThread().getName() + "\t" + "****testE");
        return "***********testE";
    }

    @GetMapping("/testHostKey")
    @SentinelResource(value = "testHostKey",blockHandler = "deal_testHostKey")
    public String testHostKey(@RequestParam(value = "p1", required = false) String p1,
                              @RequestParam(value = "p2", required = false) String p2) {
        //int i = 10/0;
        return "==========testHostKey";
    }

    public String deal_testHostKey(String p1, String p2, BlockException exception) {
        return "============deal_testHostKey /(ㄒoㄒ)/~~";
    }


}
