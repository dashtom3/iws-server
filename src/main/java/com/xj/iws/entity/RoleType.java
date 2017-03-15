package com.xj.iws.entity;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/10.
 */
public class RoleType {
    private String roleId;
    private String name;
    private List<RoleEntity> role;

    public RoleType() {
    }

    public RoleType(String roleId, String name, List<RoleEntity> role) {
        this.roleId = roleId;
        this.name = name;
        this.role = role;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
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
