package com.xj.iws.http.mvc.service;

import com.xj.iws.http.mvc.entity.DeviceEntity;
import com.xj.iws.http.mvc.entity.DeviceGroupEntity;
import com.xj.iws.http.mvc.entity.RoomEntity;
import com.xj.iws.common.utils.DataWrapper;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/9.
 */
public interface RoomService {

    DataWrapper<RoomEntity> add(RoomEntity roomEntity);

    DataWrapper<Void> delete(int roomId);

    DataWrapper<RoomEntity> update(RoomEntity roomEntity);

    DataWrapper<RoomEntity> detail(int roomId);

    DataWrapper<Void> addDevice(DeviceEntity deviceEntity, DeviceEntity[] devices);

    DataWrapper<Void> updateDevice(DeviceEntity deviceEntity, DeviceEntity[] devices);

    DataWrapper<Void> deleteDevice(int groupId);

    DataWrapper<List<DeviceGroupEntity>> deviceList(int roomId);

    DataWrapper<DeviceGroupEntity> groupDetail(int groupId);

    DataWrapper<Void> enable(int groupId);

    DataWrapper<Void> start(String[] groupIds);

    DataWrapper<DeviceEntity> deviceDetail(int deviceId);
}
