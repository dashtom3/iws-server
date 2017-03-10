package com.xj.iws.entity;

import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * 系统资料实体类
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Alias("SystemEntity")
public class SystemEntity {

    private int id; //系统id
    private String name; //系统名称
    private String pic; //系统图标
    private List<LocationEntity> location;

    public SystemEntity() {
    }

    public SystemEntity(int id, String name, String pic, List<LocationEntity> location) {
        this.id = id;
        this.name = name;
        this.pic = pic;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public List<LocationEntity> getLocation() {
        return location;
    }

    public void setLocation(List<LocationEntity> location) {
        this.location = location;
    }
}
