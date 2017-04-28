package com.xj.iws.http.mvc.service.impl;

import com.xj.iws.http.mvc.dao.*;
import com.xj.iws.http.mvc.entity.*;
import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.http.mvc.service.RoomService;
import com.xj.iws.common.utils.DataWrapper;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/9.
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomDao roomDao;
    @Autowired
    DeviceDao deviceDao;
    @Autowired
    LocationDao locationDao;
    @Autowired
    ServerDao serverDao;

    @Override
    public DataWrapper<RoomEntity> add(RoomEntity roomEntity) {
        DataWrapper<RoomEntity> dataWrapper = new DataWrapper<RoomEntity>();

        int id = roomDao.add(roomEntity);
        roomEntity.setId(id);
        dataWrapper.setData(roomEntity);
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> delete(int roomId) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();

        int sign = roomDao.delete(roomId);
        if (sign == -1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<RoomEntity> update(RoomEntity roomEntity) {
        DataWrapper<RoomEntity> dataWrapper = new DataWrapper<RoomEntity>();
        int sign = roomDao.update(roomEntity);
        if (sign == -1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        } else {
            dataWrapper.setData(roomEntity);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<RoomEntity> detail(int roomId) {
        DataWrapper<RoomEntity> dataWrapper = new DataWrapper<RoomEntity>();

        //获取泵房详情
        RoomEntity room = roomDao.detail(roomId);
        //获取泵房所属地点
        LocationEntity location = locationDao.detail(room.getLocationId());
        //获取泵房内所有控制器

        List<DeviceGroupEntity> groups = deviceDao.groupList(roomId);

        room.setLocation(location);
        room.setDeviceGroups(groups);

        if (room == null) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        } else {
            dataWrapper.setData(room);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> addDevice(DeviceEntity deviceEntity, DeviceEntity[] devices) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        int i = deviceDao.addGroup(deviceEntity);
        int j = deviceDao.addDevice(deviceEntity,devices);
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> updateDevice(DeviceEntity deviceEntity, DeviceEntity[] devices) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        int i = deviceDao.updateGroup(deviceEntity);
        int j = deviceDao.deleteDevice(deviceEntity.getGroupId());
        int k = deviceDao.addDevice(deviceEntity,devices);
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> deleteDevice(int groupId) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        int i = deviceDao.deleteDevice(groupId);
        int j = deviceDao.deleteGroup(groupId);
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<DeviceGroupEntity>> deviceList(int roomId) {
        DataWrapper<List<DeviceGroupEntity>> dataWrapper = new DataWrapper<List<DeviceGroupEntity>>();
        List<DeviceGroupEntity> groups =  deviceDao.groupList(roomId);
        dataWrapper.setData(groups);
        return dataWrapper;
    }

    @Override
    public DataWrapper<DeviceGroupEntity> groupDetail(int groupId) {
        DataWrapper<DeviceGroupEntity> dataWrapper = new DataWrapper<DeviceGroupEntity>();
        DeviceGroupEntity group = deviceDao.groupDetail(groupId);
        group.setDevices(deviceDao.deviceList(groupId));
        return dataWrapper;
    }

    @Override
    public DataWrapper<DeviceEntity> deviceDetail(int deviceId) {
        DataWrapper<DeviceEntity> dataWrapper = new DataWrapper<DeviceEntity>();
        DeviceEntity device = deviceDao.deviceDetail(deviceId);
        dataWrapper.setData(device);
        return dataWrapper;
    }


    @Override
    public DataWrapper<Void> enable(int groupId) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        List<DeviceEntity> devices = deviceDao.deviceList(groupId);

        String IP = serverDao.getIP();

        for (DeviceEntity device : devices) {
            String port = deviceDao.getPort(device.getId());
            int i = deviceDao.createDataTable(IP,port,device);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> start(String[] groupIds) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httpPost
        HttpPost httpPost = new HttpPost("http://localhost:8180/iws_data/api/start");
        // 创建参数队列
        List<BasicNameValuePair> formParams = new ArrayList<BasicNameValuePair>();
        for (String groupId : groupIds) {
            formParams.add(new BasicNameValuePair("groupIds", groupId));
        }
        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(formParams, "UTF-8");
            httpPost.setEntity(uefEntity);
            CloseableHttpResponse response = httpclient.execute(httpPost);

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return dataWrapper;
    }
}
