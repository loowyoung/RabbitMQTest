package com.anxin.rabbitconsumer.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: ly
 * @date: 2019/9/19 9:04
 */
@Component
@RabbitListener(queues = "topic.a")
public class TopicAConsumer {
    @RabbitHandler
    public void recieved(String msg) {
        System.out.println("topic模式队列A： " + msg);
    }
}
