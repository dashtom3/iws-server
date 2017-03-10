package com.xj.iws.entity;

import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * 系统资料实体类
 * @author Created by XiaoJiang01 on 2017/2/21.
 */
@Alias("SystemEntity")
public class SystemEntity {

    private int id;
    private String name;
    private String pic;
    private String describes;
    private List<LocationEntity> location;

    public SystemEntity() {
    }

    public SystemEntity(int id, String name, String pic, String describes, List<LocationEntity> location) {
        this.id = id;
        this.name = name;
        this.pic = pic;
        this.describes = describes;
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

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public List<LocationEntity> getLocation() {
        return location;
    }

    public void setLocation(List<LocationEntity> location) {
        this.location = location;
    }
}
