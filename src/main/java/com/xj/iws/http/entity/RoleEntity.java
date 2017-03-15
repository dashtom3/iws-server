package com.xj.iws.http.entity;

import org.apache.ibatis.type.Alias;

/**
 * 角色信息实体类
 *
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Alias("RoleEntity")
public class RoleEntity {
    private int id;
    private String roleId;
    private int systemId;
    private int provinceId;
    private int cityId;
    private int areaId;
    private int limitation;
    private String name;
    private String describes;

    public RoleEntity() {
    }

    public RoleEntity(int id, String roleId, int systemId, int provinceId, int cityId, int areaId, int limitation, String name, String describes) {
        this.id = id;
        this.roleId = roleId;
        this.systemId = systemId;
        this.provinceId = provinceId;
        this.cityId = cityId;
        this.areaId = areaId;
        this.limitation = limitation;
        this.name = name;
        this.describes = describes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int systemId) {
        this.systemId = systemId;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public int getLimitation() {
        return limitation;
    }

    public void setLimitation(int limitation) {
        this.limitation = limitation;
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
