package com.xj.iws.http.mvc.service.impl;

import com.xj.iws.common.data.DataProcess;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.dao.DataDao;
import com.xj.iws.http.mvc.dao.DeviceDao;
import com.xj.iws.http.mvc.dao.DeviceTermDao;
import com.xj.iws.http.mvc.dao.ServerDao;
import com.xj.iws.http.mvc.entity.DataEntity;
import com.xj.iws.http.mvc.entity.PointFieldEntity;
import com.xj.iws.http.mvc.entity.ViewDataEntity;
import com.xj.iws.http.mvc.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/3/31.
 */
@Service
public class DataServiceImpl implements DataService {

    @Autowired
    DataDao dataDao;
    @Autowired
    DeviceTermDao deviceTermDao;
    @Autowired
    DataProcess dataProcess;
    @Autowired
    ServerDao serverDao;
    @Autowired
    DeviceDao deviceDao;

    @Override
    public DataWrapper<List<ViewDataEntity>> query(Map<String, String> conditions) {
        DataWrapper<List<ViewDataEntity>> dataWrapper = new DataWrapper<List<ViewDataEntity>>();
        String IP = serverDao.getIP();
        String port = deviceDao.getPort(conditions.get("deviceId"));
        String number = deviceDao.getNumber(conditions.get("deviceId"));

        conditions.put("tableName","data_"+IP+":"+port+"#"+number);

        List<DataEntity> datas = dataDao.query(conditions);

        List<PointFieldEntity> pointFields = deviceTermDao.fieldList(Integer.parseInt(conditions.get("deviceId")));
        dataProcess.enable(pointFields);
        List<ViewDataEntity> viewDatas = dataProcess.process(datas);

        dataWrapper.setData(viewDatas);
        return dataWrapper;
    }

    @Override
    public DataWrapper<ViewDataEntity> presentData(String deviceId) {
        DataWrapper<ViewDataEntity> dataWrapper = new DataWrapper<ViewDataEntity>();
        String IP = serverDao.getIP();
        String port = deviceDao.getPort(deviceId);
        String number = deviceDao.getNumber(deviceId);

        String tableName = "data_"+IP+":"+port+"#"+number;

        List<DataEntity> datas = dataDao.presentData(deviceId,tableName);

        List<PointFieldEntity> pointFields = deviceTermDao.fieldList(Integer.parseInt(deviceId));
        dataProcess.enable(pointFields);
        ViewDataEntity viewData = dataProcess.process(datas).get(0);

        dataWrapper.setData(viewData);
        return dataWrapper;
    }

}
