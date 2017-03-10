package com.xj.iws.service.impl;

import com.xj.iws.dao.AreaDao;
import com.xj.iws.dao.EquipmentDao;
import com.xj.iws.dao.LocationDao;
import com.xj.iws.dao.RoomDao;
import com.xj.iws.entity.EquipmentEntity;
import com.xj.iws.entity.LocationEntity;
import com.xj.iws.entity.RoomEntity;
import com.xj.iws.entity.SystemEntity;
import com.xj.iws.entity.area.AreaEntity;
import com.xj.iws.enums.CallStatusEnum;
import com.xj.iws.enums.ErrorCodeEnum;
import com.xj.iws.service.RoomService;
import com.xj.iws.utils.DataWrapper;
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
    EquipmentDao equipmentDao;
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
        LocationEntity location = locationDao.location(room.getLocationId());
        //获取泵房内所有控制器
        List<EquipmentEntity> equipments = equipmentDao.equipments(roomId);

        room.setLocation(location);
        room.setEquipment(equipments);

        if (room != null){
            dataWrapper.setData(room);
            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        }
        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }
}
