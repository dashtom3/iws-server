package com.xj.iws.http.mvc.entity;

import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/4/19.
 */
@Alias("DeviceGroupModelEntity")
public class DeviceGroupModelEntity {
    private int groupId;
    private int roomId;
    private String name;
    private String describes;

    private List<DeviceEntity> devices;

    public DeviceGroupModelEntity() {
    }

    public DeviceGroupModelEntity(int groupId, int roomId, String name, String describes, List<DeviceEntity> devices) {
        this.groupId = groupId;
        this.roomId = roomId;
        this.name = name;
        this.describes = describes;
        this.devices = devices;
    }

    public int getGroupId() {

        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public List<DeviceEntity> getDevices() {
        return devices;
    }

    public void setDevices(List<DeviceEntity> devices) {
        this.devices = devices;
    }
}
