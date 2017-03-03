package com.xj.iws.dao.impl;

import com.xj.iws.dao.LocationDao;
import com.xj.iws.entity.LocationEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by XiaoJiang01 on 2017/3/3.
 */
@Repository
public class LocationDaoImpl extends BaseDao implements LocationDao {

    final String TABLE = "location_";
    boolean sign = false;

    /**
     * 添加地点
     *
     * @param score
     * @param value
     * @return
     */
    @Override
    @Transactional
    public boolean add(final Long score, LocationEntity value) {

        //初始化索引
        final String index = INDEX + TABLE;

        //初始化key
        final String key = BASIC + TABLE + score;

        //初始化value
        final String systemId = value.getSystemId();
        final String positionId = value.getPositionId();
        final String positionX = value.getPositionX();
        final String positionY = value.getPositionY();
        final String name = value.getName();
        final String blockId = value.getBlockId();
        final String blockName = value.getBlockName();

        redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                //序列化参数
                byte[] index0 = serializer().serialize(index);
                byte[] key0 = serializer().serialize(key);
                byte[] systemId0 = serializer().serialize(systemId);
                byte[] positionId0 = serializer().serialize(positionId);
                byte[] positionX0 = serializer().serialize(positionX);
                byte[] positionY0 = serializer().serialize(positionY);
                byte[] name0 = serializer().serialize(name);
                byte[] blockId0 = serializer().serialize(blockId);
                byte[] blockName0 = serializer().serialize(blockName);

                //格式化value
                Map<byte[], byte[]> map = new HashMap<byte[], byte[]>();
                map.put("id".getBytes(), key0);
                map.put("systemId".getBytes(), systemId0);
                map.put("positionId".getBytes(), positionId0);
                map.put("positionX".getBytes(), positionX0);
                map.put("positionY".getBytes(), positionY0);
                map.put("name".getBytes(), name0);
                map.put("blockId".getBytes(), blockId0);
                map.put("blockName".getBytes(), blockName0);

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
     * 删除地点
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
     * 编辑地点
     *
     * @param location
     */
    @Override
    public void update(LocationEntity location) {
        //初始化key
        String key = location.getId();

        //格式化value
        Map<String, String> value = new HashMap<String, String>();
        value.put("systemId", location.getSystemId());
        value.put("positionId", location.getPositionId());
        value.put("positionX", location.getPositionX());
        value.put("positionY", location.getPositionY());
        value.put("name", location.getName());
        value.put("blockId", location.getBlockId());
        value.put("blockName", location.getBlockName());

        //编辑
        rHash().putAll(key, value);
    }

    /**
     * 获取地点详情
     *
     * @param key
     * @return
     */
    @Override
    public Map<String, String> detail(String key) {
        return rHash().entries(key);
    }

    /**
     * 获取地点列表
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
     * 查询地点总数
     *
     * @return
     */
    @Override
    public Long getCount() {
        return rZSet().size(INDEX + TABLE);
    }
}
