package com.xj.iws.http.mvc.entity;

import org.apache.ibatis.type.Alias;

/**
 * Created by XiaoJiang01 on 2017/3/21.
 */
@Alias("DeviceEntity")
public class DeviceEntity {
    private int id;
    private int groupId;
    private int termId;
    private int roomId;
    private int status;
    private String port;
    private String number;
    private String name;
    private String describes;

    private DeviceTermEntity deviceTerm;

    private String groupName;

    public DeviceEntity() {
    }

    public DeviceEntity(int id, int groupId, int termId, int roomId, int status, String port, String number, String name, String describes) {
        this.id = id;
        this.groupId = groupId;
        this.termId = termId;
        this.roomId = roomId;
        this.status = status;
        this.port = port;
        this.number = number;
        this.name = name;
        this.describes = describes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getTermId() {
        return termId;
    }

    public void setTermId(int termId) {
        this.termId = termId;
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

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public DeviceTermEntity getDeviceTerm() {
        return deviceTerm;
    }

    public void setDeviceTerm(DeviceTermEntity deviceTerm) {
        this.deviceTerm = deviceTerm;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
