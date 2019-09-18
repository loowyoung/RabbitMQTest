package com.anxin.rabbitproducer.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: ly
 * @date: 2019/9/18 9:08
 * @description rabbit消息生产者
 */
@Component
public class RabbitProducer {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    //普通队列模式
    public void stringSend() {
        Date date = new Date();
        String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        System.out.println("生产者发送的消息为" + dateString);
        rabbitTemplate.convertAndSend("ly-duilie", dateString);
    }

    //fanout属于广播模式
    public void fanoutSend() {
        Date date = new Date();
        String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        System.out.println("广播发送的消息为" + dateString);
        // 注意 第一个参数是我们交换机的名称 ，第二个参数是routerKey 我们不用管空着就可以，第三个是你要发送的消息
        rabbitTemplate.convertAndSend("ly-exchange", "", dateString);
    }

}
