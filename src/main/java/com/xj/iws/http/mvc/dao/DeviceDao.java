package com.xj.iws.http.mvc.dao;

import com.xj.iws.http.mvc.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/21.
 */
@Repository
public interface DeviceDao {

    List<DeviceEntity> deviceList(@Param("groupId") int groupId);

    List<DeviceGroupEntity> deviceGroupList();

    DeviceGroupEntity groupDetail(int groupId);

    DeviceEntity deviceDetail(int deviceId);

    int addGroup(DeviceGroupEntity deviceGroup);

    int addDevice(@Param("device") DeviceEntity device,@Param("terms") DeviceEntity[] deviceEntities);

    int deleteGroup(int deviceGroupId);

    int deleteDevice(@Param("groupId") int groupId,@Param("deviceId") int deviceId);

    int updateGroup(DeviceGroupEntity deviceGroup);

    int createDataTable(DeviceEntity device);

    List<Integer> groupIds(int roomId);

    String getPort(String deviceId);

    String getNumber(String deviceId);

    List<DeviceGroupTypeEntity> groupTypes();

    int addGroupModel(DeviceEntity deviceEntity);
}
