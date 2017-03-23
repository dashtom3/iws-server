package com.xj.iws.http.service;

import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.entity.DeviceInfoEntity;
import com.xj.iws.http.entity.UserEntity;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/21.
 */
public interface DeviceInfoService {

    DataWrapper<List<DeviceInfoEntity>> list();

    DataWrapper<Void> update(DeviceInfoEntity deviceInfoEntity);
}
