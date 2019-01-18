package com.vincce.fun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Created By Baoning On 2019-01-17
 *
 *  opsForValue：用来操作简单属性数据
 *  opsForList:操作含有ist数据
 *  opsForSet:操作含有set的数据
 *  opsForZSet:操作含有ZSet(有序set)的数据
 *  opsForHash:操作含有hash的数据
 *
 *
 */
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;



}
