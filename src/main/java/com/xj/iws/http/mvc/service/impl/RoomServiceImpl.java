package com.xj.iws.http.mvc.service.impl;

import com.xj.iws.http.mvc.dao.DeviceDao;
import com.xj.iws.http.mvc.dao.LocationDao;
import com.xj.iws.http.mvc.dao.RoomDao;
import com.xj.iws.http.mvc.entity.*;
import com.xj.iws.common.enums.CallStatusEnum;
import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.http.mvc.service.RoomService;
import com.xj.iws.common.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/9.
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomDao roomDao;
    @Autowired
    DeviceDao deviceDao;
    @Autowired
    LocationDao locationDao;

    @Override
    public DataWrapper<RoomEntity> add(RoomEntity roomEntity) {
        DataWrapper<RoomEntity> dataWrapper = new DataWrapper<RoomEntity>();

        int id = roomDao.add(roomEntity);
        roomEntity.setId(id);
        dataWrapper.setData(roomEntity);
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> delete(int roomId) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();

        int sign = roomDao.delete(roomId);
        if (sign == -1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<RoomEntity> update(RoomEntity roomEntity) {
        DataWrapper<RoomEntity> dataWrapper = new DataWrapper<RoomEntity>();
        int sign = roomDao.update(roomEntity);
        if (sign == -1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        } else {
            dataWrapper.setData(roomEntity);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<RoomEntity> detail(int roomId) {
        DataWrapper<RoomEntity> dataWrapper = new DataWrapper<RoomEntity>();

        //获取泵房详情
        RoomEntity room = roomDao.detail(roomId);
        //获取泵房所属地点
        LocationEntity location = locationDao.detail(room.getLocationId());
        //获取泵房内所有控制器
        List<Integer> groupIds = deviceDao.groupIds(roomId);
        List<DeviceGroupEntity> deviceGroups = new ArrayList<DeviceGroupEntity>();
        for (int groupId : groupIds){
            DeviceGroupEntity group = deviceDao.groupDetail(groupId);
            List<DeviceEntity> devices = deviceDao.deviceList(groupId);
            group.setDevices(devices);
        }

        room.setLocation(location);
        room.setDevices(deviceGroups);

        if (room == null) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        } else {
            dataWrapper.setData(room);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> addDevice(DeviceEntity deviceEntity, DeviceEntity[] devices) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        int i = deviceDao.addGroupModel(deviceEntity);
        int j = deviceDao.addDevice(deviceEntity,devices);
        return dataWrapper;
    }

}
