package com.xj.iws.entity;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/10.
 */
public class RoleType {
    private long roleId;
    private String name;
    private List<RoleEntity> role;

    public RoleType() {
    }

    public RoleType(long roleId, String name, List<RoleEntity> role) {
        this.roleId = roleId;
        this.name = name;
        this.role = role;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RoleEntity> getRole() {
        return role;
    }

    public void setRole(List<RoleEntity> role) {
        this.role = role;
    }
}
