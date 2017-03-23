package com.xj.iws.http.entity;

import org.apache.ibatis.type.Alias;

/**
 * Created by XiaoJiang01 on 2017/3/21.
 */
@Alias("DeviceEntity")
public class DeviceEntity {
    private int id;
    private int roomId;
    private String deviceInfo;
    private int parameterId;
    private String com;
    private String num;
    private int status;
    private String name;
    private String describes;

    public DeviceEntity() {
    }

    public DeviceEntity(int id, int roomId, String deviceInfo, int parameterId, String com, String num, int status, String name, String describes) {
        this.id = id;
        this.roomId = roomId;
        this.deviceInfo = deviceInfo;
        this.parameterId = parameterId;
        this.com = com;
        this.num = num;
        this.status = status;
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

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public int getParameterId() {
        return parameterId;
    }

    public void setParameterId(int parameterId) {
        this.parameterId = parameterId;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
}
