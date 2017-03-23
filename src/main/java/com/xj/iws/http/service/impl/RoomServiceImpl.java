package com.xj.iws.http.service.impl;

import com.xj.iws.http.dao.DeviceDao;
import com.xj.iws.http.dao.LocationDao;
import com.xj.iws.http.dao.RoomDao;
import com.xj.iws.http.entity.DeviceEntity;
import com.xj.iws.http.entity.LocationEntity;
import com.xj.iws.http.entity.RoomEntity;
import com.xj.iws.common.enums.CallStatusEnum;
import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.http.service.RoomService;
import com.xj.iws.common.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public DataWrapper<Void> add(RoomEntity roomEntity) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

        int sign = roomDao.add(roomEntity);
        if (sign == 1){
            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        }
        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> delete(int roomId) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

        int sign = roomDao.delete(roomId);
        if (sign == 1){
            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        }
        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> update(RoomEntity roomEntity) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

        int sign = roomDao.update(roomEntity);
        if (sign == 1){
            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        }
        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }

    @Override
    public DataWrapper<RoomEntity> detail(int roomId) {
        DataWrapper<RoomEntity> dataWrapper = new DataWrapper<RoomEntity>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

        //获取泵房详情
        RoomEntity room = roomDao.detail(roomId);
        //获取泵房所属地点
        LocationEntity location = locationDao.detail(room.getLocationId());
        //获取泵房内所有控制器
        List<DeviceEntity> devices = deviceDao.list(roomId);

        room.setLocation(location);
        room.setDevices(devices);

        if (room != null){
            dataWrapper.setData(room);
            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        }
        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }
}
