package com.xj.iws.http.dao;

import com.xj.iws.http.entity.LocationEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/3/3.
 */
public interface LocationDao {
    LocationEntity location(int locationId);

    List<LocationEntity> list(int systemId);

    int add(LocationEntity locationEntity);

    int delete(int locationId);

    int update(LocationEntity locationEntity);

    LocationEntity detail(int locationId);

    List<LocationEntity> query(Map<String,String> condition);
}
