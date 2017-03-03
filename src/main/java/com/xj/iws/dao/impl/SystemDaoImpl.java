package com.xj.iws.dao.impl;

import com.xj.iws.dao.SystemDao;
import com.xj.iws.entity.SystemEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.security.Key;
import java.util.HashMap;
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
    public boolean add(final Long score, SystemEntity value) {

        //初始化索引
        final String index = INDEX+TABLE;

        //初始化key
        final String key = BASIC + TABLE + score;

        //初始化value
        final String name = value.getName();
        final String pic = value.getPic();

        redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                //序列化参数
                byte[] index0 = serializer().serialize(index);
                byte[] key0 = serializer().serialize(key);
                byte[] name0 = serializer().serialize(name);
                byte[] pic0 = serializer().serialize(pic);

                //格式化value
                Map<byte[],byte[]> map = new HashMap<byte[],byte[]>();
                map.put("id".getBytes(),key0);
                map.put("name".getBytes(),name0);
                map.put("pic".getBytes(),pic0);

                //开启事务
                connection.multi();
                connection.hMSet(key0,map);
                connection.zAdd(index0,score,key0);
                connection.exec();
                return true;
            }
        });
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
