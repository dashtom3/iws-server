package com.xj.iws.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;

/**
 * Created by XiaoJiang01 on 2017/3/1.
 */
@Repository
public class BaseDao {

    //数据类型标识符
    protected final String BASIC = "basic_";
    protected final String INDEX = "index_";
    protected final String STATE = "state_";
    protected final String LOGS0 = "logs0_";

    @Autowired
    protected RedisTemplate redisTemplate;

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    ValueOperations rValue(){return redisTemplate.opsForValue();
    }

    HashOperations rHash(){
        return redisTemplate.opsForHash();
    }

    ZSetOperations rZSet(){
        return redisTemplate.opsForZSet();
    }

    SetOperations rSet(){
        return redisTemplate.opsForSet();
    }

    ListOperations rList(){
        return redisTemplate.opsForList();
    }

    RedisSerializer getRedisSerializer(){
        return redisTemplate.getStringSerializer();
    }
}
