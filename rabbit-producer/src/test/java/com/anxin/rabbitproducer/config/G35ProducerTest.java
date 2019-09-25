package com.anxin.rabbitproducer.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author: ly
 * @date: 2019/9/25 15:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class G35ProducerTest {

    @Autowired
    private G35Producer producer;

    @Test
    public void stringSend() {
        producer.stringSend();
    }
}