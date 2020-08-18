package com.itcast;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itcast.domain.User;
import com.itcast.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate<String,String> template;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() throws JsonProcessingException {
        String user = template.boundValueOps("users.userlist").get();
        if (user==null){
            //从数据库取数据
            List<User> userList = userMapper.findAll();
            //对象转为json字符串
            ObjectMapper objectMapper = new ObjectMapper();
            user = objectMapper.writeValueAsString(userList);
            //将数据写入redis
            template.boundValueOps("users.userlist").set(user);
            System.out.println("从数据库读取数据");
        }else{
            System.out.println("从缓存读取数据");
        }

        System.out.println(user);

    }
}
