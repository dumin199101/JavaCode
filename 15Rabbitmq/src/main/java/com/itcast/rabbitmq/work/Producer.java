package com.itcast.rabbitmq.work;

import com.itcast.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {

    static final String QUEUE_NAME = "work_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        //创建频道
        Channel channel = connection.createChannel();
        //创建队列
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        //发送消息
        for (int i = 1; i <= 30; i++) {
            String msg = "Work Queue 模式发送数据包:"+i;
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
        }
        //释放连接
        channel.close();
        connection.close();
    }
}
