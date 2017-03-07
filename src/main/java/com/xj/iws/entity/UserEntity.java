package com.xj.iws.entity;

import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * 用户信息实体类
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Alias("UserEntity")
public class UserEntity {
    private int userId;
    private int userName;
    private String password;
    private String name;
    private int roleId;
    private String pic;
    private Date date;

    public UserEntity() {
    }

    public UserEntity(int userId, int userName, String password, String name, int roleId, String pic, Date date) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.roleId = roleId;
        this.pic = pic;
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserName() {
        return userName;
    }

    public void setUserName(int userName) {
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

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
