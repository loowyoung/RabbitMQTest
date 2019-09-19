package com.anxin.rabbitproducer.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: ly
 * @date: 2019/9/18 9:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitProducerTest {

    @Autowired
    private RabbitProducer producer;

    @Test
    public void testStringSend() {
        for (int i = 0; i < 10; i++) {
            producer.stringSend();
        }
    }

    @Test
    public void testFanoutSend() {
        producer.fanoutSend();
    }

    @Test
    public void testTopic1Send() {
        producer.topic1Swnd();
    }

    @Test
    public void testTopic2Send() {
        producer.topic2Swnd();
    }

    @Test
    public void testTopic3Send() {
        producer.topic3Swnd();
    }

}