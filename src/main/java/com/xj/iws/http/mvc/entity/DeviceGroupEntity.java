package com.xj.iws.http.mvc.entity;

import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/29.
 */
@Alias("DeviceGroupEntity")
public class DeviceGroupEntity {
    private int id;
    private int roomId;
    private int status;
    private String type;
    private String name;
    private String describes;

    private RoomEntity room;
    List<DeviceEntity> devices;

    public DeviceGroupEntity() {
    }

    public DeviceGroupEntity(int id, int roomId, int status, String type, String name, String describes) {

        this.id = id;
        this.roomId = roomId;
        this.status = status;
        this.type = type;
        this.name = name;
        this.describes = describes;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }
}
