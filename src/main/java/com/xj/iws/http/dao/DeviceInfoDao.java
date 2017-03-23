package com.xj.iws.http.dao;

import com.xj.iws.http.entity.DeviceInfoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/21.
 */
@Repository
public interface DeviceInfoDao {
    List<DeviceInfoEntity> list();

    int update(DeviceInfoEntity deviceInfoEntity);
}
