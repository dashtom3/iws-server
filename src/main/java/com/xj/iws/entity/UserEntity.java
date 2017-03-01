package com.xj.iws.entity;

/**
 * 用户信息实体类
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
public class UserEntity {
    private String userId;
    private String userName;
    private String password;
    private String name;
    private String roleId;
    private String pic;
    private String date;

    public UserEntity() {
    }

    public UserEntity(String userId, String userName, String password, String name, String roleId, String pic, String date) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.roleId = roleId;
        this.pic = pic;
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
