package com.anxin.rabbitproducer.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        String str = "{ “eventinfo”:[{“capture_time”:”2017-10-10 17:09:10”," +
                "“analyze_time”:” 2017-10-10 17:10:10”," +
                "“camera_id”:”K1234466667”," +
                "“image_url”:” http://192.168.31.166:8183/imageserver/20151201T190734_813583.jpg”," +
                "   “video_slice_path”:” http://192.168.31.166:8183/imageserver/20151201T190734_813583.avi”," +
                "   “event_type”:””, " +
                "“event_class”:””," +
                "}" +
                "]" +
                "}";
        System.out.println("G35生产者发送的消息为" + str);
        rabbitTemplate.convertAndSend("FXJG", str);
    }

}
