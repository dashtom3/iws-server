package com.xj.iws.http.mvc.dao;

import com.xj.iws.http.mvc.entity.DeviceEntity;
import com.xj.iws.http.mvc.entity.DeviceGroupEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/21.
 */
@Repository
public interface DeviceDao {

    List<DeviceEntity> deviceList(int groupId);

    List<DeviceGroupEntity> deviceGroupList(int roomId);

    DeviceGroupEntity groupDetail(int groupId);

    DeviceEntity deviceDetail(int deviceId);

    int addGroup(DeviceGroupEntity deviceGroup);

    int addDevice(@Param("groupId") int id, @Param("devices") DeviceEntity[] devices);

    int deleteGroup(int deviceGroupId);

    int deleteDevice(@Param("groupId") int groupId,@Param("deviceId") int deviceId);

    int updateGroup(DeviceGroupEntity deviceGroup);

    int createDataTable(DeviceEntity device);
}
