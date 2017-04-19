package com.xj.iws.http.mvc.service;

import com.xj.iws.http.mvc.entity.LocationEntity;
import com.xj.iws.common.utils.DataWrapper;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/2/27.
 */
public interface LocationService {

    DataWrapper<LocationEntity> add(LocationEntity locationEntity);

    DataWrapper<Void> delete(int locationId);

    DataWrapper<Void> update(LocationEntity locationEntity);

    DataWrapper<LocationEntity> detail(int locationId);

    DataWrapper<List<LocationEntity>> list(int id);

    DataWrapper<List<LocationEntity>> lockedList(List<Map> conditions);

    DataWrapper<List<LocationEntity>> query(Map<String, String> condition);
}
