package com.example.manager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * redis 测试
 * @author yuanjie
 * @date 2018/11/7 17:18
 */

@SpringBootTest
@RunWith(SpringRunner.class)
@Component
public class TestRedis {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void set() {
        redisTemplate.opsForValue().set("test:set", "testValue1");
        Object ob = redisTemplate.opsForValue().get("test:set");
        System.out.println(ob);
    }
}
