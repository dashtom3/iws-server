package com.xj.iws.http.mvc.service.impl;

import com.xj.iws.common.utils.PackageUtil;
import com.xj.iws.http.mvc.dao.AreaDao;
import com.xj.iws.http.mvc.dao.LocationDao;
import com.xj.iws.http.mvc.dao.RoomDao;
import com.xj.iws.http.mvc.dao.SystemDao;
import com.xj.iws.http.mvc.entity.LocationEntity;
import com.xj.iws.http.mvc.entity.RoomEntity;
import com.xj.iws.http.mvc.entity.SystemEntity;
import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.http.mvc.entity.util.Limitation;
import com.xj.iws.http.mvc.service.LocationService;
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
    public DataWrapper<LocationEntity> add(LocationEntity locationEntity) {

        DataWrapper<LocationEntity> dataWrapper = new DataWrapper<LocationEntity>();
        int i = locationDao.add(locationEntity);
        dataWrapper.setData(locationEntity);
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
        } else {
            dataWrapper.setData(location);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<LocationEntity>> list(int id, List<Limitation> limitations) {
        DataWrapper<List<LocationEntity>> dataWrapper = new DataWrapper<List<LocationEntity>>();
        List<LocationEntity> locations = locationDao.list(id,limitations);
        List<SystemEntity> systems = systemDao.list(limitations);
        dataWrapper.setData(PackageUtil.locationSetSystem(locations, systems));
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<LocationEntity>> lockedList(List<Map> conditions) {
        DataWrapper<List<LocationEntity>> dataWrapper = new DataWrapper<List<LocationEntity>>();
        List<LocationEntity> locations = new ArrayList<LocationEntity>();
        for (Map condition : conditions) {
            locations.addAll(locationDao.query(condition));
        }
        dataWrapper.setData(locations);
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<LocationEntity>> query(Map<String, String> condition) {
        DataWrapper<List<LocationEntity>> dataWrapper = new DataWrapper<List<LocationEntity>>();
        List<LocationEntity> locations = locationDao.query(condition);
        if (locations == null) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }


}
