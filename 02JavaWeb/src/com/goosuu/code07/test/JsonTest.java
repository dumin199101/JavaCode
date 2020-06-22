package com.goosuu.code07.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.goosuu.code05.User;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JsonTest {
    @Test
    public void javaToJsontest() throws JsonProcessingException {
        User user = new User("lisi",22,new Date());
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(user);
        System.out.println(s);
    }

    @Test
    public void javaListToJsontest() throws JsonProcessingException {
        User user1= new User("zhangsan", 20, new Date());
        User user2= new User("lisi", 26, new Date());
        User user3= new User("wangwu", 28, new Date());
        ArrayList<User> userArrayList = new ArrayList<User>();
        userArrayList.add(user1);
        userArrayList.add(user2);
        userArrayList.add(user3);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(userArrayList);
        System.out.println(s);
    }

    @Test
    public void javaMapToJsontest() throws JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        map.put("name", "wangyuanyuan");
        map.put("age","29");
        map.put("sex","female");
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(map);
        System.out.println(s);
    }

    @Test
    public void JsonToJavatest() throws IOException {
        String json = "{\"date\":\"2020-02-01\",\"name\":\"wangyuanyuan\",\"age\":\"29\"}";
        ObjectMapper mapp = new ObjectMapper();
        User user = mapp.readValue(json, User.class);
        System.out.println(user);
    }
}
