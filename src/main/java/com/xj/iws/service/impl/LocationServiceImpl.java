package com.xj.iws.service.impl;

import com.xj.iws.dao.LocationDao;
import com.xj.iws.entity.LocationEntity;
import com.xj.iws.enums.CallStatusEnum;
import com.xj.iws.enums.ErrorCodeEnum;
import com.xj.iws.service.LocationService;
import com.xj.iws.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by XiaoJiang01 on 2017/2/27.
 */
@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationDao locationDao;

    @Override
    public DataWrapper add(LocationEntity locationEntity) {

        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

        //生成score
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Long score = Long.valueOf(dateFormat.format(new Date()));

        //写入数据
//        boolean sign = locationDao.add(score, locationEntity);
//        if (sign){
//            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
//        }
        return dataWrapper;
    }

    @Override
    public DataWrapper delete(String locationId) {

        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

//        boolean sign = locationDao.delete(locationId);
//        if (sign){
//            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
//        }
        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }

    @Override
    public DataWrapper update(LocationEntity location) {

        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

//        locationDao.update(location);
        dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }

    @Override
    public DataWrapper list(String systemId ,String positationId) {

        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

//        locationDao.list(systemId ,positationId);
        dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }

    @Override
    public DataWrapper detail(String locationId) {

        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

//        locationDao.detail(locationId);
        dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }


}
