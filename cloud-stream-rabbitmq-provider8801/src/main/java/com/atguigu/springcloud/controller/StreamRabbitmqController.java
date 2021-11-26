package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.ImessageProviderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @auther konglingyang
 * @date 2021/11/25 19:39
 */
@RestController
public class StreamRabbitmqController {

    @Resource
    private ImessageProviderService imessageProviderService;

    @GetMapping("/sendMessage")
    public String getStream() {
        String send = imessageProviderService.send();
        return send;
    }
}
