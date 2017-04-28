package com.xj.iws.http.mvc.dao;

import com.xj.iws.http.mvc.entity.DeviceTermEntity;
import com.xj.iws.http.mvc.entity.DeviceTypeEntity;
import com.xj.iws.http.mvc.entity.PointFieldEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/3/25.
 */
@Repository
public interface DeviceTermDao {
    List<DeviceTermEntity> deviceTermList(int type);

    List<PointFieldEntity> fieldList(int deviceId);

    List<PointFieldEntity> fieldDetail(int fieldId);

    int deleteDevice(int pointTableId);

    int deleteField(int pointTableId);

    int update(DeviceTermEntity deviceTermEntity);

    DeviceTermEntity detail(int pointTableId);

    int addDevice(DeviceTermEntity deviceTermEntity);

    int addField(@Param("deviceId") int id, @Param("fields") PointFieldEntity[] fields);

    List<DeviceTermEntity> query(Map<String, String> condition);

    List<DeviceTypeEntity> typeList();

    List<DeviceTermEntity> deviceTermByIds(String[] terms);
}