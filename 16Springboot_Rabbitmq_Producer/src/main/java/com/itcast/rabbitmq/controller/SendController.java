package com.itcast.rabbitmq.controller;

import com.itcast.rabbitmq.config.RabbitmqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/send")
    public String send(@RequestParam String key,@RequestParam String msg){
        rabbitTemplate.convertAndSend(RabbitmqConfig.ITEM_TOPIC_EXCHANGE,key,msg);
        return "消息发送成功";
    }
}
