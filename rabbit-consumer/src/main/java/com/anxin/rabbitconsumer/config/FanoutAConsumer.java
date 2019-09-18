package com.anxin.rabbitconsumer.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: ly
 * @date: 2019/9/18 10:31
 */
@Component
@RabbitListener(queues = "fanout-a")
public class FanoutAConsumer {

    @RabbitHandler
    public void recieved(String msg) {
        System.out.println("fanout-A消费者： " + msg);
    }
}
