package com.anxin.rabbitconsumer.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: ly
 * @date: 2019/9/18 9:34
 * @description rabbitmq消费者
 */
@Component
@RabbitListener(queues = "ly-duilie")
public class RabbitConsumer {

    @RabbitHandler
    public void recieved(String Msg) {
        System.out.println("消费者接受的消息" + Msg);
    }
}
