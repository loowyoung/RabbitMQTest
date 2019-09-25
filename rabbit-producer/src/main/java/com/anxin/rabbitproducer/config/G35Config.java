package com.anxin.rabbitproducer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: ly
 * @date: 2019/9/25 15:26
 */
@Configuration
public class G35Config {

    //定义队列名
    private final static String QUEUE_NAME = "FXJG";

    /**
     * 定义lyDuilie队列，普通队列模式
     *
     * @return
     */
    @Bean
    public Queue g35Queue() {
        return new Queue(QUEUE_NAME);
    }
}
