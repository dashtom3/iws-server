package com.xj.iws.http.mvc.service;

import com.xj.iws.http.mvc.entity.DeviceEntity;
import com.xj.iws.http.mvc.entity.DeviceGroupModelEntity;
import com.xj.iws.http.mvc.entity.RoomEntity;
import com.xj.iws.common.utils.DataWrapper;

/**
 * Created by XiaoJiang01 on 2017/3/9.
 */
public interface RoomService {

    DataWrapper<RoomEntity> add(RoomEntity roomEntity);

    DataWrapper<Void> delete(int roomId);

    DataWrapper<RoomEntity> update(RoomEntity roomEntity);

    DataWrapper<RoomEntity> detail(int roomId);

    DataWrapper<Void> addDevice(DeviceEntity deviceEntity, DeviceEntity[] devices);
}
