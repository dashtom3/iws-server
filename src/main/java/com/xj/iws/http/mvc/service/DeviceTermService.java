package com.xj.iws.http.mvc.service;

import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.entity.DeviceTermEntity;
import com.xj.iws.http.mvc.entity.PointFieldEntity;
import com.xj.iws.http.mvc.entity.PointRoleEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/3/24.
 */
public interface DeviceTermService {
    DataWrapper<List<PointRoleEntity>> pointRole();

    DataWrapper<Void> delete(int pointTableId);

    DataWrapper<List<DeviceTermEntity>> list();

    DataWrapper<DeviceTermEntity> detail(int pointTableId);

    DataWrapper<DeviceTermEntity> update(DeviceTermEntity deviceTermEntity);

    DataWrapper<DeviceTermEntity> add(DeviceTermEntity deviceTermEntity, PointFieldEntity[] fields);

    DataWrapper<List<DeviceTermEntity>> query(Map<String, String> condition);
}
