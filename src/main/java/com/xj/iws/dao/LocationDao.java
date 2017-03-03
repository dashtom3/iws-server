package com.xj.iws.dao;

import com.xj.iws.entity.LocationEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/3/3.
 */
public interface LocationDao {
    @Transactional
    boolean add(Long score, LocationEntity value);

    @Transactional
    boolean delete(String id);

    void update(LocationEntity location);

    Map<String, String> detail(String key);

    List<Map<String,String>> list(String... q);

    Long getCount();
}
