package com.xj.iws.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by XiaoJiang01 on 2017/3/1.
 */
@Repository
public class BaseDao {

    //数据库基本调用方法
    @Autowired
    protected RedisTemplate<Serializable, Serializable> redis;

    //String 数据调用方法
    protected ValueOperations rValue = getValueOperations();

    //hash 数据调用方法
    protected HashOperations rHash = getHashOperations();

    //zSet 数据调用方法
    protected ZSetOperations rZSet = getZSetOperations();

    //set 数据调用方法
    protected SetOperations rSet = getSetOperations();

    //list 数据调用方法
    protected ListOperations rList = getListOperations();

    //数据标识符
    protected final String BASIC = "basic_";
    protected final String STATE = "state_";
    protected final String INDEX = "index_";
    protected final String LOGS0 = "logs0_";

    ValueOperations getValueOperations(){
        return redis.opsForValue();
    }
    HashOperations getHashOperations(){
        return redis.opsForHash();
    }
    ZSetOperations getZSetOperations(){
        return redis.opsForZSet();
    }
    SetOperations getSetOperations(){
        return redis.opsForSet();
    }
    ListOperations getListOperations(){
        return redis.opsForList();
    }
}
