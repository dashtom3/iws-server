package com.xj.iws.entity;

import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * 地点资料实体类
 * 标识到小区
 *
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Alias("LocationEntity")
public class LocationEntity {

    private int id;
    private int systemId;
    private int areaId;
    private double positionX;
    private double positionY;
    private String name;
    private SystemEntity system;
    private List<RoomEntity> room;

    public LocationEntity() {
    }

    public LocationEntity(int id, int systemId, int areaId, double positionX, double positionY, String name, SystemEntity system, List<RoomEntity> room) {
        this.id = id;
        this.systemId = systemId;
        this.areaId = areaId;
        this.positionX = positionX;
        this.positionY = positionY;
        this.name = name;
        this.system = system;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int systemId) {
        this.systemId = systemId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SystemEntity getSystem() {
        return system;
    }

    public void setSystem(SystemEntity system) {
        this.system = system;
    }

    public List<RoomEntity> getRoom() {
        return room;
    }

    public void setRoom(List<RoomEntity> room) {
        this.room = room;
    }
}
