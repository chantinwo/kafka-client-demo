package com.szxs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @RequestMapping("/sendMsgToKafka")
    public String sendMsgToKafka(){
        for (int i = 10; i < 20; i++) {
            //                      topic名称             键           值
            kafkaTemplate.send("dmw_test_consumer","dm","hello,kafka!--->"+i);
        }
        return "发送消息到kafka完毕";
    }

}
