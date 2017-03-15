package com.xj.iws.http.entity;

import org.apache.ibatis.type.Alias;

import java.util.Map;

/**
 * 设备部署实例实体类
 *
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Alias("EquipmentEntity")
public class EquipmentEntity {
    private int id;
    private int roomId;
    private String equipmentType;
    private int parameterId;
    private String com;
    private int num;
    private String name;
    private String describes;
    private RoomEntity room;
    private Map<String,Integer> parameter;

    public EquipmentEntity() {
    }

    public EquipmentEntity(int id, int roomId, String equipmentType, int parameterId, String com, int num, String name, String describes, RoomEntity room, Map<String, Integer> parameter) {
        this.id = id;
        this.roomId = roomId;
        this.equipmentType = equipmentType;
        this.parameterId = parameterId;
        this.com = com;
        this.num = num;
        this.name = name;
        this.describes = describes;
        this.room = room;
        this.parameter = parameter;
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

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
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

    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }

    public Map<String, Integer> getParameter() {
        return parameter;
    }

    public void setParameter(Map<String, Integer> parameter) {
        this.parameter = parameter;
    }
}
