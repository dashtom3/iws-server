package com.xj.iws.http.service.impl;

import com.xj.iws.http.dao.AreaDao;
import com.xj.iws.http.dao.LocationDao;
import com.xj.iws.http.dao.RoomDao;
import com.xj.iws.http.dao.SystemDao;
import com.xj.iws.http.entity.LocationEntity;
import com.xj.iws.http.entity.RoomEntity;
import com.xj.iws.http.entity.SystemEntity;
import com.xj.iws.common.enums.CallStatusEnum;
import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.http.service.LocationService;
import com.xj.iws.common.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by XiaoJiang01 on 2017/2/27.
 */
@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationDao locationDao;
    @Autowired
    SystemDao systemDao;
    @Autowired
    RoomDao roomDao;
    @Autowired
    AreaDao areaDao;

    @Override
    public DataWrapper<Void> add(LocationEntity locationEntity) {

        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        int sign = locationDao.add(locationEntity);

        if (sign != 1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> delete(int locationId) {

        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();

        int sign = locationDao.delete(locationId);

        if (sign != 1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> update(LocationEntity locationEntity) {

        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();

        int sign = locationDao.update(locationEntity);

        if (sign != 1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<LocationEntity> detail(int locationId) {

        DataWrapper<LocationEntity> dataWrapper = new DataWrapper<LocationEntity>();

        //获取地点
        LocationEntity location = locationDao.detail(locationId);
        //获取地点所属系统
        SystemEntity system = systemDao.detail(location.getSystemId());
        //获取地点下所有泵房
        List<RoomEntity> rooms = roomDao.list(locationId);

        location.setSystem(system);
        location.setRoom(rooms);
        if (location == null) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<LocationEntity>> query(String systemId, String provinceId, String cityId, String areaId) {

        DataWrapper<List<LocationEntity>> dataWrapper = new DataWrapper<List<LocationEntity>>();

        //创建查询条件
        Map<String, String> condition = new HashMap<String, String>();

        if (systemId != null && systemId != ""){
            condition.put("systemId", systemId);
        }
        if (areaId != null && areaId != "" && areaId != "0") {
            condition.put("areaId", areaId);
        } else if (cityId != null && cityId != "" && cityId != "0") {
            condition.put("cityId", cityId);
        } else if (provinceId != null && provinceId != "" && provinceId != "0") {
            condition.put("provinceId", provinceId);
        }

        List<LocationEntity> locations = locationDao.query(condition);
        if (locations == null) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }


}
