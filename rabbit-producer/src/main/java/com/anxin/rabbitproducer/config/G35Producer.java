package com.anxin.rabbitproducer.config;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: ly
 * @date: 2019/9/25 15:27
 */
@Component
public class G35Producer {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    //普通队列模式
    public void stringSend() {
        JSONObject json1 = new JSONObject();
        json1.put("capture_time", "2017-10-10 17:09:10");
        json1.put("analyze_time", "2017-10-10 17:10:10");
        json1.put("camera_id", "K1234466667");
        json1.put("image_url", "http://192.168.31.166:8183/imageserver/20151201T190734_813583.jpg");
        json1.put("video_slice_path", "http://192.168.31.166:8183/imageserver/20151201T190734_813583.avi");
        json1.put("event_type", "1");
        json1.put("event_class", "1");
        List<JSONObject> list = new ArrayList<>();
        list.add(json1);
        JSONObject json2 = new JSONObject();
        json2.put("eventinfo", list);
        System.out.println("G35生产者发送的消息为" + json2);
        rabbitTemplate.convertAndSend("FXJG", json2);
    }

}
