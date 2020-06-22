package com.goosuu.code07.test;

import com.goosuu.code07.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;


public class RedisTest {
    @Test
    public void testRedisConnection(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.set("username","wangyuanyuan");
        String username= jedis.get("username");
        System.out.println(username);
        jedis.close();
    }

    @Test
    public void testRedisString(){
        Jedis jedis = new Jedis();
        jedis.setex("age",10,"22");
        String age = jedis.get("age");
        System.out.println(age);
        jedis.close();
    }

    @Test
    public void testRedisHash(){
        Jedis jedis = new Jedis();
        jedis.hset("user","name","wangyuanyuan");
        jedis.hset("user","city","beijing");
        jedis.hset("user", "sex", "female");
        Map<String, String> user = jedis.hgetAll("user");
        Set<String> strings = user.keySet();
        for(String s : strings){
            System.out.println(s+":"+user.get(s));
        }
        jedis.close();

    }

    @Test
    public void testRedisList(){
        Jedis jedis = new Jedis();
        jedis.lpush("strlist","b","c");
        jedis.rpush("strlist","d","e");
        List<String> strlist = jedis.lrange("strlist", 0, -1);
        for (String s : strlist) {
            System.out.println(s);
        }
        jedis.close();
    }

    @Test
    public void testReidsSet(){
        Jedis jedis = new Jedis();
        jedis.sadd("programset","java","php","c++","c#","php","javascript");
        Set<String> programset = jedis.smembers("programset");
        for (String s : programset) {
            System.out.println(s);
        }
        jedis.close();
    }

    @Test
    public void testRedisZSet(){
        Jedis jedis = new Jedis();
        jedis.zadd("scoreset", 10, "lieyan");
        jedis.zadd("scoreset", 50, "wangyuanyuan");
        jedis.zadd("scoreset", 30, "wangwei");
        Set<String> scoreset = jedis.zrange("scoreset", 0, -1);
        for (String s : scoreset) {
            System.out.println(s);
        }
        jedis.close();

    }

    @Test
    public void testRedisPool(){
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.set("girl","wangyuanyuan");
        String hello = jedis.get("girl");
        System.out.println(hello);
        jedis.close();
    }
}
