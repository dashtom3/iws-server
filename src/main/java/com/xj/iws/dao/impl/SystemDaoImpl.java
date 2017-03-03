package com.xj.iws.dao.impl;

import com.xj.iws.dao.SystemDao;
import com.xj.iws.entity.SystemEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.security.Key;
import java.util.*;

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
     * @return
     */
    @Override
    @Transactional
    public boolean add(final Long score, SystemEntity value) {

        //初始化索引
        final String index = INDEX + TABLE;

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
                Map<byte[], byte[]> map = new HashMap<byte[], byte[]>();
                map.put("id".getBytes(), key0);
                map.put("name".getBytes(), name0);
                map.put("pic".getBytes(), pic0);

                //开启事务
                connection.multi();
                connection.hMSet(key0, map);
                connection.zAdd(index0, score, key0);
                connection.exec();
                return true;
            }
        });
        //是否写入成功
        sign = rZSet().rank(INDEX + TABLE, key) != null;
        return sign;
    }

    /**
     * 删除系统
     *
     * @param id
     * @return
     */
    @Override
    @Transactional
    public boolean delete(String id) {

        //初始化索引
        final String index = INDEX + TABLE;

        //初始化key
        final String key = id;

        redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                //序列化参数
                byte[] index0 = serializer().serialize(index);
                byte[] key0 = serializer().serialize(key);

                //开启事务
                connection.multi();
                connection.del(key0);
                connection.zRem(index0, key0);
                connection.exec();
                return true;
            }
        });
        //是否写入成功
        sign = rZSet().rank(INDEX + TABLE, key) == null;
        return sign;
    }

    /**
     * 编辑系统
     *
     * @param system
     */
    @Override
    public void update(SystemEntity system) {
        //初始化key
        String key = system.getId();

        //格式化value
        Map<String, String> value = new HashMap<String, String>();
        value.put("name", system.getName());
        value.put("pic", system.getPic());

        //编辑
        rHash().putAll(key, value);
    }

    /**
     * 获取系统详情
     *
     * @param key
     * @return
     */
    @Override
    public Map<String, String> detail(String key) {
        return rHash().entries(key);
    }

    /**
     * 获取系统列表
     * @param q
     * @return
     */
    @Override
    public List<Map<String,String>> list(String... q) {

        //初始化索引
        String index = INDEX + TABLE;

        //初始化查询条件
        String id = "*";
        for (int i = 0; i < q.length; i++) {
            id = id + q[i] + "*";
        }

        //创建scan，并将查询条件写入scan
        ScanOptions scan = ScanOptions.scanOptions().match(id).build();
        //获取游标
        Cursor<ZSetOperations.TypedTuple<String>> cursor = rZSet().scan(index,scan);

        Set<String> keys = new HashSet<String>();
        //遍历游标
        while (cursor.hasNext()){
            ZSetOperations.TypedTuple<String> ops = cursor.next();
            keys.add(ops.getValue());
        }

        //创建返回结果
        List<Map<String,String>> result = new ArrayList<Map<String, String>>();
        for (String key : keys){
            result.add(rHash().entries(key));
        }
        return result;
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
