package com.itcast.rabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveMsg {
    @RabbitListener(queues = "item_queue")
    public void receive(String msg){
        System.out.println("消费者接收到的消息为:"+msg);
    }
}
