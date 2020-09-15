package com.itcast.rabbitmq.ps;

import com.itcast.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    //交换机名称
    static final String FANOUT_EXCHANE = "fanout_exchange";
    //队列名称1
    static final String FANOUT_QUEUE1 = "fanout_queue1";
    //队列名称2
    static final String FANOUT_QUEUE2 = "fanout_queue2";

    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        //创建频道
        Channel channel = connection.createChannel();
        //创建交换机
        /**
         * 声明交换机
         * 参数1：交换机名称
         * 参数2：交换机类型，fanout、topic、direct、headers
         */
        channel.exchangeDeclare(FANOUT_EXCHANE, BuiltinExchangeType.FANOUT);
        //创建队列
        channel.queueDeclare(FANOUT_QUEUE1,true,false,false,null);
        channel.queueDeclare(FANOUT_QUEUE2,true,false,false,null);
        //绑定交换机跟队列
        channel.queueBind(FANOUT_QUEUE1,FANOUT_EXCHANE,"");
        channel.queueBind(FANOUT_QUEUE2,FANOUT_EXCHANE,"");
        //发送消息
        for (int i = 1; i < 11; i++) {
            String message = "发布订阅模式发布消息"+i;
            /**
             * 参数1：交换机名称，如果没有指定则使用默认Default Exchage
             * 参数2：路由key,简单模式可以传递队列名称
             * 参数3：消息其它属性
             * 参数4：消息内容
             */
            channel.basicPublish(FANOUT_EXCHANE,"",null,message.getBytes());
        }
        //关闭连接
        channel.close();
        connection.close();


    }
}
