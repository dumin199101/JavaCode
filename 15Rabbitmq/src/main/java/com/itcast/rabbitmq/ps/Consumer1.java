package com.itcast.rabbitmq.ps;

import com.itcast.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer1 {
    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        //创建频道
        Channel channel = connection.createChannel();
        //创建交换机
        channel.exchangeDeclare(Producer.FANOUT_EXCHANE, BuiltinExchangeType.FANOUT);
        //创建队列
        channel.queueDeclare(Producer.FANOUT_QUEUE1,true,false,false,null);
        //绑定交换机跟队列
        channel.queueBind(Producer.FANOUT_QUEUE1,Producer.FANOUT_EXCHANE,"");
        //创建消费者
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("交换机："+envelope.getExchange());
                System.out.println("路由key："+envelope.getRoutingKey());
                System.out.println("消息id："+envelope.getDeliveryTag());
                System.out.println("消息："+new String(body,"utf-8"));
            }
        };
        //监听消息
        channel.basicConsume(Producer.FANOUT_QUEUE1,true,consumer);


    }
}
