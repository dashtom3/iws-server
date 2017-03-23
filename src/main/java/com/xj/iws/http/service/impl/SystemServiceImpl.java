package com.xj.iws.http.service.impl;

import com.xj.iws.http.dao.LocationDao;
import com.xj.iws.http.dao.SystemDao;
import com.xj.iws.http.entity.LocationEntity;
import com.xj.iws.http.entity.SystemEntity;
import com.xj.iws.common.enums.CallStatusEnum;
import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.http.service.SystemService;
import com.xj.iws.common.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/2/24.
 */

@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    SystemDao systemDao;
    @Autowired
    LocationDao locationDao;

    /**
     * 添加系统
     *
     * @param system
     * @return
     */
    @Override
    public DataWrapper<Void> add(SystemEntity system) {

        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        system.setStrdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString());
        int sign = systemDao.add(system);
        if (sign != 1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }

    /**
     * 删除系统
     *
     * @param systemId
     * @return
     */
    @Override
    public DataWrapper<Void> delete(int systemId) {

        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        int sign = systemDao.delete(systemId);
        if (sign != 1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }

    /**
     * 编辑系统
     *
     * @param system
     * @return
     */
    @Override
    public DataWrapper<Void> update(SystemEntity system) {

        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();

        int sign = systemDao.update(system);
        if (sign != 1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }

    /**
     * 获取系统列表
     *
     * @return
     */
    @Override
    public DataWrapper<List<SystemEntity>> list() {

        DataWrapper<List<SystemEntity>> dataWrapper = new DataWrapper<List<SystemEntity>>();
        //获取全部系统
        List<SystemEntity> systems = systemDao.list();
        //获取系统下全部地点
        for (SystemEntity system : systems) {
            system.setLocation(locationDao.list(system.getId()));
        }
        if (systems == null) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }else {
            dataWrapper.setData(systems);
        }
        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }

    /**
     * 获取系统详情
     *
     * @param systemId
     * @return
     */
    @Override
    public DataWrapper<SystemEntity> detail(int systemId) {

        DataWrapper<SystemEntity> dataWrapper = new DataWrapper<SystemEntity>();

        //获取系统
        SystemEntity system = systemDao.detail(systemId);
        //获取系统下全部地点
        List<LocationEntity> locations = locationDao.list(systemId);
        system.setLocation(locations);

        if (system == null) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }else {
            dataWrapper.setData(system);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<String>> pic() {
        DataWrapper<List<String>> dataWrapper = new DataWrapper<List<String>>();
        List<String> pics = systemDao.pic();
        if (pics == null){
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }else {
            dataWrapper.setData(pics);
        }
        return dataWrapper;
    }
}
