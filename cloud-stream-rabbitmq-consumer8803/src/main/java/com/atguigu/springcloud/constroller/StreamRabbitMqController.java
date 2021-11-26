package com.atguigu.springcloud.constroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @auther konglingyang
 * @date 2021/11/25 21:13
 */
@Component
@EnableBinding(Sink.class)
public class StreamRabbitMqController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void getMessage(Message<String> message) {
        System.out.println("*********消费者：" +
                message.getPayload() + "\t" + serverPort);
    }
}
