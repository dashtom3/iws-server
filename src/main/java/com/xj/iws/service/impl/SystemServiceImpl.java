package com.xj.iws.service.impl;

import com.xj.iws.dao.SystemDao;
import com.xj.iws.entity.SystemEntity;
import com.xj.iws.enums.CallStatusEnum;
import com.xj.iws.enums.ErrorCodeEnum;
import com.xj.iws.service.SystemService;
import com.xj.iws.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/2/24.
 */

@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    SystemDao systemDao;

    /**
     * 添加系统
     *
     * @param system
     * @return
     */
    @Override
    public DataWrapper<Void> add(SystemEntity system) {

        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

        int sign = systemDao.add(system);
        if (sign == 1){
            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        }
        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }

    /**
     * 删除系统
     *
     * @param systemId
     * @return
     */
    @Override
    public DataWrapper<Void> delete(String systemId) {

        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

        int sign = systemDao.delete(systemId);
        if (sign==1){
            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        }
        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }

    /**
     * 编辑系统
     *
     * @param system
     * @return
     */
    @Override
    public DataWrapper<Void> update(SystemEntity system) {

        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

        int sign = systemDao.update(system);
        if (sign == 1){
            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        }
        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }

    /**
     * 获取系统列表
     *
     * @return
     */
    @Override
    public DataWrapper<List<SystemEntity>> list() {

        DataWrapper<List<SystemEntity>> dataWrapper = new DataWrapper<List<SystemEntity>>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

        List<SystemEntity> result = systemDao.list();
        if (result != null){
            dataWrapper.setData(result);
            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        }
        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }

    /**
     * 获取系统详情
     * @param systemId
     * @return
     */
    @Override
    public DataWrapper<SystemEntity> detail(String systemId){

        DataWrapper<SystemEntity> dataWrapper = new DataWrapper<SystemEntity>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

        SystemEntity result = systemDao.detail(systemId);
        if (result != null){
            dataWrapper.setData(result);
            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        }
        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }

}
