package com.example.datarecursion.redis;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class RedisUtil {
    private RedisTemplate redisTemplate;

    public void put(String key, Object value) {
        //redisTemplate.opsForValue().set(key, value, 10000, TimeUnit.MILLISECONDS);

        redisTemplate.opsForValue().set(key, value);
    }

    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public boolean exist(String key) {
        return redisTemplate.opsForValue().get(key) != null;
    }
}
