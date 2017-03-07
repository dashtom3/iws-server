package com.xj.iws.entity;

import org.apache.ibatis.type.Alias;

/**
 * 地点资料实体类
 *
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Alias("LocationEntity")
public class LocationEntity {
    private int id;
    private int systemId;
    private int areaId;
    private Long positionX;
    private Long positionY;
    private String name;
    private String blockName;

    public LocationEntity() {
    }

    public LocationEntity(int id, int systemId, int areaId, Long positionX, Long positionY, String name, String blockName) {
        this.id = id;
        this.systemId = systemId;
        this.areaId = areaId;
        this.positionX = positionX;
        this.positionY = positionY;
        this.name = name;
        this.blockName = blockName;
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

    public Long getPositionX() {
        return positionX;
    }

    public void setPositionX(Long positionX) {
        this.positionX = positionX;
    }

    public Long getPositionY() {
        return positionY;
    }

    public void setPositionY(Long positionY) {
        this.positionY = positionY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }
}
