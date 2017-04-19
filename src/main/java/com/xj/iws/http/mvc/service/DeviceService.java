package com.xj.iws.http.mvc.service;

import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.entity.DeviceEntity;
import com.xj.iws.http.mvc.entity.DeviceGroupEntity;
import com.xj.iws.http.mvc.entity.DeviceGroupTypeEntity;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/14.
 */
public interface DeviceService {

    DataWrapper<DeviceGroupEntity> addGroup(DeviceGroupEntity deviceGroup);

    DataWrapper<Void> delete(int deviceGroupId);

    DataWrapper<DeviceEntity> update(DeviceGroupEntity deviceGroup);

    DataWrapper<List<DeviceGroupEntity>> groupList();

    DataWrapper<DeviceGroupEntity> groupDetail(int groupId);

    DataWrapper<Void> enable(int groupId);

    DataWrapper<Void> start(String[] groupIds);

    DataWrapper<List<DeviceGroupTypeEntity>> groupType();
}
