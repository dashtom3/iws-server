package com.xj.iws.http.mvc.entity;

import org.apache.ibatis.type.Alias;

/**
 * Created by XiaoJiang01 on 2017/3/21.
 */
@Alias("DeviceEntity")
public class DeviceEntity {
    private int id;
    private int groupId;
    private int tableId;
    private int status;
    private String num;
    private String name;
    private String describes;

    private DeviceGroupEntity deviceGroup;

    public DeviceEntity() {
    }

    public DeviceEntity(int id, int groupId, int tableId, int status, String num, String name, String describes) {
        this.id = id;
        this.groupId = groupId;
        this.tableId = tableId;
        this.status = status;
        this.num = num;
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

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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

    public DeviceGroupEntity getDeviceGroup() {
        return deviceGroup;
    }

    public void setDeviceGroup(DeviceGroupEntity deviceGroup) {
        this.deviceGroup = deviceGroup;
    }
}
