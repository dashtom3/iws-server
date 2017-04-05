package com.xj.iws.http.mvc.service.impl;

import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.common.utils.PackageUtil;
import com.xj.iws.http.mvc.dao.DeviceDao;
import com.xj.iws.http.mvc.dao.RoomDao;
import com.xj.iws.http.mvc.entity.DeviceEntity;
import com.xj.iws.http.mvc.entity.DeviceGroupEntity;
import com.xj.iws.http.mvc.entity.RoomEntity;
import com.xj.iws.http.mvc.service.DeviceService;
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
import java.util.Collections;
import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/14.
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceDao deviceDao;
    @Autowired
    RoomDao roomDao;

    @Override
    public DataWrapper<DeviceGroupEntity> add(DeviceGroupEntity deviceGroup, DeviceEntity[] devices) {
        DataWrapper<DeviceGroupEntity> dataWrapper = new DataWrapper<DeviceGroupEntity>();
        int i = deviceDao.addGroup(deviceGroup);
        int j = deviceDao.addDevice(deviceGroup.getId(), devices);
        if (i == -1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        } else {
            List<DeviceEntity> list = new ArrayList<DeviceEntity>();
            Collections.addAll(list, devices);

            deviceGroup.setDevices(list);
            dataWrapper.setData(deviceGroup);
        }

        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> delete(int deviceGroupId) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        int i = deviceDao.deleteDevice(deviceGroupId, 0);
        int j = deviceDao.deleteGroup(deviceGroupId);

        if (i != 1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<DeviceEntity> update(DeviceGroupEntity deviceGroup, DeviceEntity[] devices) {
        DataWrapper<DeviceEntity> dataWrapper = new DataWrapper<DeviceEntity>();
        int i = deviceDao.updateGroup(deviceGroup);
        int j = deviceDao.deleteDevice(deviceGroup.getId(), 0);
        int k = deviceDao.addDevice(deviceGroup.getId(), devices);

        if (i != 1) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<DeviceGroupEntity>> groupList() {
        DataWrapper<List<DeviceGroupEntity>> dataWrapper = new DataWrapper<List<DeviceGroupEntity>>();

        List<DeviceGroupEntity> deviceGroups = deviceDao.deviceGroupList(0);
        List<DeviceEntity> devices = deviceDao.deviceList(0);
        for (DeviceGroupEntity group : deviceGroups) {
            RoomEntity room = roomDao.detail(group.getRoomId());
            group.setRoom(room);
        }
        dataWrapper.setData(PackageUtil.devicePack(deviceGroups, devices));
        return dataWrapper;
    }

    @Override
    public DataWrapper<DeviceGroupEntity> groupDetail(int groupId) {
        DataWrapper<DeviceGroupEntity> dataWrapper = new DataWrapper<DeviceGroupEntity>();
        DeviceGroupEntity group = deviceDao.groupDetail(groupId);
        List<DeviceEntity> devices = deviceDao.deviceList(groupId);

        group.setDevices(devices);
        dataWrapper.setData(group);
        return dataWrapper;
    }


    @Override
    public DataWrapper<DeviceEntity> deviceDetail(int deviceId) {
        DataWrapper<DeviceEntity> dataWrapper = new DataWrapper<DeviceEntity>();
        DeviceEntity device = deviceDao.deviceDetail(deviceId);
        DeviceGroupEntity group = deviceDao.groupDetail(device.getGroupId());

        device.setDeviceGroup(group);
        dataWrapper.setData(device);
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> enable(int groupId) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        List<DeviceEntity> devices = deviceDao.deviceList(groupId);
        for (DeviceEntity device : devices) {
            int i = deviceDao.createDataTable(device);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<String> start(String com) {
        DataWrapper<String> dataWrapper = new DataWrapper<String>();
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httpPost
        HttpPost httpPost = new HttpPost("http://localhost:8180/api/device/start.do");
        // 创建参数队列
        List<BasicNameValuePair> formParams = new ArrayList<BasicNameValuePair>();
        formParams.add(new BasicNameValuePair("com", com));
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
