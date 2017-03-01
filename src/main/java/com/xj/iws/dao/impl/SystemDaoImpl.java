package com.xj.iws.dao.impl;

import com.sun.javafx.collections.MappingChange;
import com.xj.iws.dao.SystemDao;
import com.xj.iws.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/3/1.
 */
@Repository
public class SystemDaoImpl extends BaseDao implements SystemDao{

    final String TABLE = "system_";

    public void add(String key, Map value){
        rHash.putAll(BASIC+TABLE+key,value);
        rZSet.add(INDEX + TABLE, BASIC + TABLE + key, getCount()+1);
    }

    public Long getCount(){
        return rZSet.size(INDEX+TABLE);
    }

}
