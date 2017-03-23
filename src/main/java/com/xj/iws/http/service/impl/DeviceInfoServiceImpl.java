package com.xj.iws.http.service.impl;

import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.dao.DeviceInfoDao;
import com.xj.iws.http.entity.DeviceInfoEntity;
import com.xj.iws.http.entity.UserEntity;
import com.xj.iws.http.service.DeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/21.
 */
@Service
public class DeviceInfoServiceImpl implements DeviceInfoService {
    @Autowired
    DeviceInfoDao deviceInfoDao;

    @Override
    public DataWrapper<List<DeviceInfoEntity>> list() {
        DataWrapper<List<DeviceInfoEntity>> dataWrapper = new DataWrapper<List<DeviceInfoEntity>>();
        dataWrapper.setData(deviceInfoDao.list());
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> update(DeviceInfoEntity deviceInfoEntity) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        int i = deviceInfoDao.update(deviceInfoEntity);
        if (i != 1){
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }
}
