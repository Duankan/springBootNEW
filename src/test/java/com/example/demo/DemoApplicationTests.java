package com.example.demo;

import com.example.demo.entity.Work;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void contextLoads() {
        // 保存字符串
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }
    @Test
    public void serializer(){
        Work work=new Work();
        Work work2=new Work();
        work.setId(1);
        work.setDeptId(1);
        work.setSalary(new BigDecimal(15000));
        work.setName("dankin");
        work2.setId(2);
        work2.setDeptId(1);
        work2.setSalary(new BigDecimal(15000));
        work2.setName("doris");
        List<Work> list=new ArrayList<>();
        list.add(work);
        list.add(work2);
        redisTemplate.opsForValue().set("ls",list);
        redisTemplate.opsForValue().set("work2",work2);
        System.out.println(redisTemplate.opsForValue().get("ls"));
//        Assert.assertEquals("dankin",redisTemplate.opsForValue().get("work").getName());
    }
}

