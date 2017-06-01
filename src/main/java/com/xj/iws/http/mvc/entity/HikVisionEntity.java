package com.xj.iws.http.mvc.entity;

import org.apache.ibatis.type.Alias;

/**
 * Created by XiaoJiang01 on 2017/5/27.
 */
@Alias("HikVisionEntity")
public class HikVisionEntity {
    private int id;
    private int roomId;

    private String ip;
    private String port;
    private String username;
    private String password;

    private String protocol;
    private String streamType;
    private String channelID;
    private String zeroChannel;

    private String name;
    private String describes;

    public HikVisionEntity() {
        protocol = "1";
        streamType = "1";
        channelID = "1";
        zeroChannel = "false";
    }

    public HikVisionEntity(int id, int roomId, String ip, String port, String username, String password, String protocol, String streamType, String channelID, String zeroChannel, String name, String describes) {
        this.id = id;
        this.roomId = roomId;
        this.ip = ip;
        this.port = port;
        this.username = username;
        this.password = password;
        this.protocol = protocol;
        this.streamType = streamType;
        this.channelID = channelID;
        this.zeroChannel = zeroChannel;
        this.name = name;
        this.describes = describes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getStreamType() {
        return streamType;
    }

    public void setStreamType(String streamType) {
        this.streamType = streamType;
    }

    public String getChannelID() {
        return channelID;
    }

    public void setChannelID(String channelID) {
        this.channelID = channelID;
    }

    public String getZeroChannel() {
        return zeroChannel;
    }

    public void setZeroChannel(String zeroChannel) {
        this.zeroChannel = zeroChannel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }
}
