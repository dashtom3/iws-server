package com.xj.iws.http.mvc.service;

import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.entity.DeviceEntity;
import com.xj.iws.http.mvc.entity.DeviceGroupEntity;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/14.
 */
public interface DeviceService {

    DataWrapper<DeviceGroupEntity> add(DeviceGroupEntity deviceGroup, DeviceEntity[] devices);

    DataWrapper<Void> delete(int deviceGroupId);

    DataWrapper<DeviceEntity> update(DeviceGroupEntity deviceGroup, DeviceEntity[] devices);

    DataWrapper<List<DeviceGroupEntity>> groupList();

    DataWrapper<DeviceGroupEntity> groupDetail(int groupId);

    DataWrapper<DeviceEntity> deviceDetail(int deviceId);

    DataWrapper<Void> enable(int groupId);

    DataWrapper<String> start(String com);
}
