package com.xj.iws.dao;

import com.xj.iws.entity.SystemEntity;

import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/3/1.
 */
public interface SystemDao {
    boolean add(Long score, SystemEntity value);
    Long getCount();
}
