package com.xj.iws.dao.impl;

import com.xj.iws.dao.SystemDao;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/3/1.
 */
@Repository
public class SystemDaoImpl extends BaseDao implements SystemDao {

    final String TABLE = "system_";
    boolean sign = false;

    /**
     * 添加系统
     *
     * @param score
     * @param value
     */
    @Override
    @Transactional
    public boolean add(Long score, final Map value) {
        //初始化key
        String key = BASIC + TABLE + score;
        //该项是否存在
        if (rZSet().rank(INDEX + TABLE, key) == null) {
            //写入数据
            rHash().putAll(key, value);
            //写入索引
            rZSet().add(INDEX + TABLE, key, score);
        } else {
            return sign;
        }
        //是否写入成功
        sign = rZSet().rank(INDEX + TABLE, key) != null;
        return sign;
    }


    /**
     * 查询系统总数
     *
     * @return
     */
    @Override
    public Long getCount() {
        return rZSet().size(INDEX + TABLE);
    }

}
