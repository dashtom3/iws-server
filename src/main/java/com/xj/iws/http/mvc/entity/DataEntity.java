package com.xj.iws.http.mvc.entity;

import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * 数据资料实体类
 *
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Alias("DataEntity")
public class DataEntity {
    private int id;
    private int groupId;
    private int deviceId;
    private String num;
    private Date time;
    private String error;
    private String data;

    public DataEntity() {
    }

    public DataEntity(int id, int groupId, int deviceId, String num, Date time, String error, String data) {

        this.id = id;
        this.groupId = groupId;
        this.deviceId = deviceId;
        this.num = num;
        this.time = time;
        this.error = error;
        this.data = data;
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

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataEntity{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", deviceId=" + deviceId +
                ", num='" + num + '\'' +
                ", time=" + time +
                ", error='" + error + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
