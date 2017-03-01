package com.xj.iws.dao.impl;

import com.xj.iws.dao.CommonDao;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Set;

/**
 * Created by XiaoJiang01 on 2017/2/24.
 */
@Repository
public class CommonDaoImpl implements CommonDao {

    //redis连接，需调试成 SpringMVC 注入
    Jedis jedis = new Jedis("localhost");
    String result = null;

    /**
     * 添加基本数据
     *
     * @param value
     * @param key
     * @return
     */
    @Override
    public String addHash(String key, Map<String, String> value) {
        if (!jedis.exists(key)) {
            String i = jedis.hmset(key, value);

            if ("OK".equals(i)) {
                result = key;
            } else {
                result = "Error";
            }
        } else {
            result = "Exist";
        }
        return result;
    }

    /**
     * 添加状态、索引数据
     *
     * @param value
     * @param key
     * @return
     */
    @Override
    public String addSet(String key, String value) {
        Long i = jedis.sadd(key, value);
        if (0 != i) {
            result = value;
        } else {
            result = "Error";
        }
        return result;
    }

    /**
     * 修改hash数据
     *
     * @param value
     * @param key
     * @return
     */
    @Override
    public String updateHash(String key, Map<String, String> value) {
        if (jedis.exists(key)) {
            String i = jedis.hmset(key, value);
            if ("OK".equals(i)) {
                result = key;
            } else {
                result = "Error";
            }
        } else {
            result = "Unfound";
        }
        return result;
    }

    /**
     * 删除状态、索引数据
     *
     * @param value
     * @param key
     * @return
     */
    @Override
    public String deleteSet(String key, String value) {
        Long i = jedis.srem(key, value);
        if (0 != i) {
            result = key;
        } else {
            result = "Error";
        }
        return result;
    }

    /**
     * 删除key
     *
     * @param key
     * @return
     */
    @Override
    public String deleteKey(String key) {
        if ("OK".equals(jedis.del(key))) {
            result = key;
        } else {
            result = "Error";
        }
        return result;
    }

    /**
     * 查询数量
     * @param key
     * @return
     */
    @Override
    public Long getCount(String key) {
        return jedis.scard(key);
    }

    /**
     * 查询key
     * @param key
     * @return
     */
    @Override
    public Set<String> getKey(String key) {
        return jedis.smembers(key);
    }

    /**
     * 查询详情
     * @param key
     * @return
     */
    @Override
    public Map<String,String> getHash(String key){
        return jedis.hgetAll(key);
    }

    /**
     * 获取某一字段
     * @param key
     * @param field
     * @return
     */
    @Override
    public String getHashField(String key, String field) {
        return jedis.hget(key,field);
    }

}
