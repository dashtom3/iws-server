package com.xj.iws.entity;

/**
 * 地点资料实体类
 *
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
public class LocationEntity {
    private String id;
    private String systemId;
    private String positionId;
    private String positionX;
    private String positionY;
    private String name;
    private String blockId;
    private String blockName;

    public LocationEntity() {
    }

    public LocationEntity(String id, String systemId, String positionId, String positionX, String positionY, String name, String blockId, String blockName) {
        this.id = id;
        this.systemId = systemId;
        this.positionId = positionId;
        this.positionX = positionX;
        this.positionY = positionY;
        this.name = name;
        this.blockId = blockId;
        this.blockName = blockName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPositionX() {
        return positionX;
    }

    public void setPositionX(String positionX) {
        this.positionX = positionX;
    }

    public String getPositionY() {
        return positionY;
    }

    public void setPositionY(String positionY) {
        this.positionY = positionY;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }
}
