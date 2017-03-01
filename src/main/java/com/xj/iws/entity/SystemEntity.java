package com.xj.iws.entity;

/**
 * 系统资料实体类
 * @author Created by XiaoJiang01 on 2017/2/21.
 */

public class SystemEntity {

    private String id; //系统id
    private String name; //系统名称
    private String pic; //系统图标

    public SystemEntity() {
    }

    public SystemEntity(String id, String name, String pic) {

        this.id = id;
        this.name = name;
        this.pic = pic;
    }

    public String getId() { return id; }

    public void setId(String id) {
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
}
