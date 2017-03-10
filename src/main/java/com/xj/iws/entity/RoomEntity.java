package com.xj.iws.entity;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/9.
 */
public class RoomEntity {
    private int id;
    private int locationId;
    private String name;
    private LocationEntity location;
    private List<EquipmentEntity> equipment;

    public RoomEntity() {

    }

    public RoomEntity(int id, int locationId, String name, LocationEntity location, List<EquipmentEntity> equipment) {
        this.id = id;
        this.locationId = locationId;
        this.name = name;
        this.location = location;
        this.equipment = equipment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocationEntity getLocation() {
        return location;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }

    public List<EquipmentEntity> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<EquipmentEntity> equipment) {
        this.equipment = equipment;
    }
}
