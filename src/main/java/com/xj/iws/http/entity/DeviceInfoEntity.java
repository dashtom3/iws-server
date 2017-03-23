package com.xj.iws.http.entity;

import org.apache.ibatis.type.Alias;

/**
 * Created by XiaoJiang01 on 2017/3/21.
 */
@Alias("DeviceInfoEntity")
public class DeviceInfoEntity {
    private int id;
    private String protocol;
    private int parameter;
    private String name;
    private String pic;
    private String describes;

    public DeviceInfoEntity() {
    }

    public DeviceInfoEntity(int id, String protocol, int parameter, String name, String pic, String describes) {
        this.id = id;
        this.protocol = protocol;
        this.parameter = parameter;
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

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public int getParameter() {
        return parameter;
    }

    public void setParameter(int parameter) {
        this.parameter = parameter;
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
