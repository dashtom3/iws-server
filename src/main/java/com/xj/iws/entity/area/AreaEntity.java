package com.xj.iws.entity.area;

import org.apache.ibatis.type.Alias;

/**
 * Created by XiaoJiang01 on 2017/3/8.
 */
@Alias("AreaEntity")
public class AreaEntity {
    private int id;
    private int areaId;
    private String name;
    private int cityId;
    private CityEntity city;

    public AreaEntity() {
    }

    public AreaEntity(int id, int areaId, String name, int cityId, CityEntity city) {
        this.id = id;
        this.areaId = areaId;
        this.name = name;
        this.cityId = cityId;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }
}
