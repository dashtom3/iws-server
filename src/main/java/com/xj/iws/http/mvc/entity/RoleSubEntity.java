package com.xj.iws.http.mvc.entity;

import com.xj.iws.http.mvc.entity.area.AreaEntity;
import org.apache.ibatis.type.Alias;

/**
 * Created by XiaoJiang01 on 2017/3/23.
 */
@Alias("RoleSubEntity")
public class RoleSubEntity {
    private int id;
    private int roleId;
    private int systemId;
    private int areaId;
    private int limitation;

    private String systemName;
    private RoleEntity role;
    private AreaEntity area;

    public RoleSubEntity() {

    }

    public RoleSubEntity(int id, int roleId, int systemId, int areaId, int limitation) {
        this.id = id;
        this.roleId = roleId;
        this.systemId = systemId;
        this.areaId = areaId;
        this.limitation = limitation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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

    public int getLimitation() {
        return limitation;
    }

    public void setLimitation(int limitation) {
        this.limitation = limitation;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public AreaEntity getArea() {
        return area;
    }

    public void setArea(AreaEntity area) {
        this.area = area;
    }
}