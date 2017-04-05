package com.xj.iws.http.mvc.entity;

import org.apache.ibatis.type.Alias;

/**
 * Created by XiaoJiang01 on 2017/3/21.
 */
@Alias("DeviceTypeEntity")
public class DeviceTypeEntity {
    private int id;
    private String name;
    private String pic;
    private String describes;


    public DeviceTypeEntity() {
    }

    public DeviceTypeEntity(int id, String name, String pic, String describes) {
        this.id = id;
        this.name = name;
        this.pic = pic;
        this.describes = describes;
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
}
