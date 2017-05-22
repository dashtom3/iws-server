package com.xj.iws.http.mvc.service.impl;

import com.xj.iws.common.data.DataProcess;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.dao.*;
import com.xj.iws.http.mvc.entity.DataEntity;
import com.xj.iws.http.mvc.entity.DeviceEntity;
import com.xj.iws.http.mvc.entity.PointFieldEntity;
import com.xj.iws.http.mvc.entity.util.DataField;
import com.xj.iws.http.mvc.entity.util.ViewDataEntity;
import com.xj.iws.http.mvc.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public DataWrapper<List<ViewDataEntity>> query(Map<String, String> conditions,Page page) {
        DataWrapper<List<ViewDataEntity>> dataWrapper = new DataWrapper<List<ViewDataEntity>>();
        String IP = serverDao.getIP();
        int deviceId = Integer.parseInt(conditions.get("deviceId"));
        DeviceEntity device = deviceDao.deviceDetail(deviceId);

        String port = device.getPort();
        String number = device.getNumber();
        int termId = device.getTermId();

        conditions.put("tableName", "data_" + IP + ":" + port + "#" + number);

        List<DataEntity> datas = dataDao.query(conditions,page);
        List<PointFieldEntity> pointFields = deviceTermDao.fieldList(termId);
        dataProcess.enable(pointFields);
        List<ViewDataEntity> viewDatas = dataProcess.process(datas);

        int totalNumber = dataDao.getCount(conditions);
        dataWrapper.setPage(page,totalNumber);

        dataWrapper.setData(viewDatas);
        return dataWrapper;
    }

    @Override
    public DataWrapper<ViewDataEntity> presentData(int deviceId) {
        DataWrapper<ViewDataEntity> dataWrapper = new DataWrapper<ViewDataEntity>();

        String IP = serverDao.getIP();
        DeviceEntity device = deviceDao.deviceDetail(deviceId);

        String port = device.getPort();
        String number = device.getNumber();
        int termId = device.getTermId();

        String tableName = "data_" + IP + ":" + port + "#" + number;

        List<DataEntity> datas = dataDao.presentData(deviceId, tableName);

        List<PointFieldEntity> pointFields = deviceTermDao.fieldList(termId);
        dataProcess.enable(pointFields);
        ViewDataEntity viewData = dataProcess.process(datas).get(0);

        dataWrapper.setData(viewData);
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<DataField>> pumpStatus(int deviceId) {
        DataWrapper<List<DataField>> dataWrapper = new DataWrapper<List<DataField>>();
        String IP = serverDao.getIP();
        DeviceEntity device = deviceDao.deviceDetail(deviceId);

        String port = device.getPort();
        String number = device.getNumber();
        int termId = device.getTermId();

        String tableName = "data_" + IP + ":" + port + "#" + number;

        List<DataEntity> datas = dataDao.presentData(deviceId, tableName);

        List<PointFieldEntity> pointFields = deviceTermDao.fieldList(termId);
        dataProcess.enable(pointFields);

        List<DataField> pumpStatus = dataProcess.pumpStatus(datas.get(0));


        dataWrapper.setData(pumpStatus);
        return dataWrapper;
    }


}
