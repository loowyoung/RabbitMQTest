package com.anxin.rabbitproducer.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: ly
 * @date: 2019/9/18 9:02
 * @description rabbitmq配置类
 */
@Configuration
public class RabbitConfig {

    //定义队列名
    private final static String QUEUE_NAME = "ly-duilie";

    /**
     * 定义lyDuilie队列，普通队列模式
     *
     * @return
     */
    @Bean
    public Queue lyDuilie() {
        return new Queue(QUEUE_NAME);
    }

    //=================== fanout 模式  ====================
    @Bean
    public Queue fanoutA() {
        return new Queue("fanout-a");
    }

    @Bean
    public Queue fanoutB() {
        return new Queue("fanout-b");
    }

    @Bean
    public Queue fanoutC() {
        return new Queue("fanout-c");
    }

    /**
     * 定义一个名为ly-exchange的fanout交换器
     *
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("ly-exchange");
    }

    //消息队列与交换机绑定
    @Bean
    public Binding bindExchangeWithA() {
        return BindingBuilder.bind(fanoutA()).to(fanoutExchange());
    }

    @Bean
    public Binding bindExchangeWithB() {
        return BindingBuilder.bind(fanoutB()).to(fanoutExchange());
    }

    @Bean
    public Binding bindExchangeWithC() {
        return BindingBuilder.bind(fanoutC()).to(fanoutExchange());
    }

    //#################topic模式########################


}
