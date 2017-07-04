package com.xj.iws.http.mvc.service.impl;

import com.xj.iws.common.communication.ServerRequest;
import com.xj.iws.common.data.DataProcess;
import com.xj.iws.common.enums.ErrorCodeEnum;
import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.common.utils.Page;
import com.xj.iws.common.utils.ParamUtil;
import com.xj.iws.common.utils.TimeUtil;
import com.xj.iws.http.mvc.dao.*;
import com.xj.iws.http.mvc.dao.redis.RedisBase;
import com.xj.iws.http.mvc.entity.DataEntity;
import com.xj.iws.http.mvc.entity.DeviceEntity;
import com.xj.iws.http.mvc.entity.DeviceTermEntity;
import com.xj.iws.http.mvc.entity.PointFieldEntity;
import com.xj.iws.http.mvc.entity.util.DataField;
import com.xj.iws.http.mvc.entity.util.ViewDataEntity;
import com.xj.iws.http.mvc.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

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
    DeviceDao deviceDao;
    @Autowired
    RedisBase redisBase;


    @Override
    public DataWrapper<List<ViewDataEntity>> query(Map<String, String> conditions, Page page) {
        DataWrapper<List<ViewDataEntity>> dataWrapper = new DataWrapper<List<ViewDataEntity>>();
        conditions.put("tableName", "data_" + preConditions(Integer.parseInt(conditions.get("deviceId"))));

        List<DataEntity> datas = dataDao.query(conditions, page);

        List<ViewDataEntity> viewDatas = dataProcess.process(datas);

        int totalNumber = dataDao.getCount(conditions);
        dataWrapper.setPage(page, totalNumber);

        dataWrapper.setData(viewDatas);
        return dataWrapper;
    }

    public DataWrapper<List<ViewDataEntity>> dataAtPresentDate(Map<String, String> conditions, Page page) {
        DataWrapper<List<ViewDataEntity>> dataWrapper = new DataWrapper<List<ViewDataEntity>>();
        String date = TimeUtil.getDate(new Date(), 0);
        int deviceId = Integer.parseInt(conditions.get("deviceId"));
        DeviceEntity device = deviceDao.deviceDetail(deviceId);


        String port = device.getPort();
        String number = device.getNumber();
        int count = device.getCount();
        int bit = device.getBit();

        String tableName = "data_" + date + "_" + preConditions(deviceId);
        String startTime = conditions.get("startTime").split(" ")[1].replaceAll(":", "");
        String endTime = conditions.get("endTime").split(" ")[1].replaceAll(":", "");
        int timeStep = Integer.parseInt(conditions.get("timeStep"));

        Object[] dataSet = redisBase.zSetOps().rangeByScoreWithScores(tableName, Double.valueOf(startTime), Double.valueOf(endTime)).toArray();
        List<String> tempList = new ArrayList<String>();
        for (int i = 0; i <dataSet.length ;i++ ) {
            ZSetOperations.TypedTuple<String> ops = (ZSetOperations.TypedTuple<String>)dataSet[i];
            if (ops.getScore() % timeStep == 0){
                tempList.add(ops.getValue());
            }
        }
        int totalNumber = tempList.size();

        List<String> dataList = new ArrayList<String>();
        for (int i = page.getCurrentNumber(); i < page.getNumberPerPage() ; i++) {
            try {
                dataList.add(tempList.get(i));
            }catch (Exception e){
                break;
            }
        }

        List<DataEntity> dataEntities = new ArrayList<DataEntity>();
        for (String temp : dataList) {
            String[] arrayTemp = temp.split(":");
            String strTime = date + arrayTemp[0];
            Date time = null;
            try {
                time = TimeUtil.changeStringToDate(strTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String data = arrayTemp[1];
            String exception = arrayTemp[2];

            DataEntity dataEntity = new DataEntity(0, deviceId, port, number, time, exception, count, bit, data);
            dataEntities.add(dataEntity);
        }

        List<ViewDataEntity> viewData = dataProcess.process(dataEntities);
        dataWrapper.setData(viewData);
        dataWrapper.setPage(page, totalNumber);
        return dataWrapper;
    }

    @Override
    public DataWrapper<ViewDataEntity> presentData(int deviceId) {
        DataWrapper<ViewDataEntity> dataWrapper = new DataWrapper<ViewDataEntity>();

        String tableName = "data_" + preConditions(deviceId);

        List<DataEntity> datas = dataDao.presentData(deviceId, tableName);
        ViewDataEntity viewData = dataProcess.process(datas).get(0);

        dataWrapper.setData(viewData);
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<DataField>> pumpStatus(int deviceId) {
        DataWrapper<List<DataField>> dataWrapper = new DataWrapper<List<DataField>>();

        String tableName = preConditions(deviceId);

        List<DataEntity> datas = dataDao.presentData(deviceId, tableName);
        List<DataField> pumpStatus = dataProcess.pumpStatus(datas.get(0));

        dataWrapper.setData(pumpStatus);
        return dataWrapper;
    }

    @Override
    public DataWrapper<ViewDataEntity> pointData(String termId, String port, String number) {
        DataWrapper<ViewDataEntity> dataWrapper = new DataWrapper<ViewDataEntity>();
        DeviceTermEntity deviceTerm = deviceTermDao.detail(Integer.parseInt(termId));

        String param = ParamUtil.stringify("termId:" + termId, "port:" + port, "number" + number);
        Map<String, Object> response = ServerRequest.send("http://localhost:8180/iws_data/api/device/pointData", param);

        String data = null;
        if (null != response && "SUCCEED".equals(response.get("callStatus"))) {
            data = (String) response.get("data");
        } else {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        if (null != data) {
            int count = deviceTerm.getCount();
            int length = deviceTermDao.getBit(Integer.parseInt(termId));

            DataEntity dataEntity = new DataEntity(0, 0, port, number, new Date(), "ER", count, length, data);
            List<DataEntity> datas = new ArrayList<DataEntity>();
            datas.add(dataEntity);

            List<PointFieldEntity> pointFields = deviceTermDao.fieldList(Integer.parseInt(termId));
            dataProcess.enable(pointFields);

            List<ViewDataEntity> viewDatas = dataProcess.process(datas);
            dataWrapper.setData(viewDatas.get(0));

        }
        return dataWrapper;
    }

    private String preConditions(int deviceId) {
        DeviceEntity device = deviceDao.deviceDetail(deviceId);

        String port = device.getPort();
        String number = device.getNumber();
        int termId = device.getTermId();

        List<PointFieldEntity> pointFields = deviceTermDao.fieldList(termId);
        dataProcess.enable(pointFields);

        return port + "#" + number;
    }

}
