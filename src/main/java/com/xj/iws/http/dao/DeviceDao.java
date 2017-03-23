package com.xj.iws.http.dao;

import com.xj.iws.http.entity.DeviceEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/21.
 */
@Repository
public interface DeviceDao {

    List<DeviceEntity> list(int roomId);
}
