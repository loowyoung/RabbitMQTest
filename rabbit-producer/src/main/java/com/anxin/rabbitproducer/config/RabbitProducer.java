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

    /**
     * topic广播模式
     * key为topic.msg 只会接收包含topic.msg的消息
     * key为topic.#   那么会接收以topic开头的消息
     * key为topic.*.z 那么他只会接收topic.B.z这样格式的消息
     * #匹配多次，*匹配一次
     */
    public void topic1Swnd() {
        Date date = new Date();
        String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        System.out.println("topic广播发送的消息为" + dateString);
        //这条消息会被key为topic.msg和topic.# 收到
        rabbitTemplate.convertAndSend("topicExchange", "topic.msg", dateString);
    }

    //topic广播模式
    public void topic2Swnd() {
        Date date = new Date();
        String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        System.out.println("topic广播发送的消息为" + dateString);
        //这条消息会被key为topic.*.z和topic.# 收到
        rabbitTemplate.convertAndSend("topicExchange", "topic.msg.z", dateString);
    }

    //topic广播模式
    public void topic3Swnd() {
        Date date = new Date();
        String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        System.out.println("topic广播发送的消息为" + dateString);
        //这条消息会被key为topic.# 收到
        rabbitTemplate.convertAndSend("topicExchange", "topic.msg.aa", dateString);
    }

}
