package com.jiang.dao.impl;

import redis.clients.jedis.Jedis;

/**
 * Created by XiaoJiang01 on 2017/2/16.
 */
public class TestDao {
    public String set(String a){
        Jedis jedis = new Jedis("localhost");
        String flag = jedis.set("a",a+"  redis OK");
        return flag;
    }
    public String get(){
        Jedis jedis = new Jedis("localhost");
        String flag = jedis.get("a");
        return flag;
    }

}
