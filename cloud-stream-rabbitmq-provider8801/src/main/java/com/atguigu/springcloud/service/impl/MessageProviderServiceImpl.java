package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.ImessageProviderService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;


import javax.annotation.Resource;
import java.util.UUID;

/**
 * @auther konglingyang
 * @date 2021/11/25 15:34
 */
@EnableBinding(Source.class)
public class MessageProviderServiceImpl implements ImessageProviderService {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());  // 创建并发送消息
        System.out.println("********Serial" + serial);
        return serial;
    }
}
