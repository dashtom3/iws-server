package com.xj.iws.service.impl;

import com.xj.iws.enums.ErrorCodeEnum;
import com.xj.iws.service.LocationService;
import com.xj.iws.utils.DataWrapper;
import org.springframework.stereotype.Service;

/**
 * Created by XiaoJiang01 on 2017/2/27.
 */
@Service
public class LocationServiceImpl implements LocationService {

    String table = "location";

    @Override
    public DataWrapper add(String name, String positationX, String positationY, String positationId, String systemId, String blockId, String blockName) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

//        //初始化参数
//        Map<String, String> value = new HashMap<String, String>();
//        value.put("name", name);
//        value.put("positationX", positationX);
//        value.put("positationY", positationY);
//        value.put("positationId", positationId);
//        value.put("systemId", systemId);
//        value.put("blockId", blockId);
//        value.put("blockName", blockName);
//
//        //获取编号
//        Long num = commonDao.getCount("index_" + table) + 1;
//        //生成key
//        String key = "basic_" + table + "_" + positationId + "_" + systemId + "_" + num;
//        //写入数据
//        String result = commonDao.addHash(key, value);
//        //添加索引
//        if (key.equals(result)) {
//            String s = commonDao.addSet("index_" + table, key);
//            if (key.equals(s)) {
//                dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
//            }
//        }
        return dataWrapper;
    }

    @Override
    public DataWrapper delete(String locationId) {

        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

//        //删除数据
//        String result = commonDao.deleteKey(locationId);
//        //删除索引
//        if (locationId.equals(result)) {
//            String s = commonDao.deleteSet("index_" + table, locationId);
//            if (locationId.equals(s)) {
//                dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
//            }
//        }
        return dataWrapper;
    }

    @Override
    public DataWrapper update(String locationId, String locationName, String systemId, String blockId, String blockName) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

//        //初始化参数
//        Map<String, String> value = new HashMap<String, String>();
//        value.put("locationName", locationName);
//        value.put("systemId", systemId);
//        value.put("blockId", blockId);
//        value.put("blockName", blockName);
//        //编辑数据
//        String result = commonDao.updateHash(locationId, value);
//
//        if (locationId.equals(result)) {
//            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
//        }
        return dataWrapper;
    }

    @Override
    public DataWrapper list(String name, String positationId, String systemId) {

        return null;
    }

    @Override
    public DataWrapper detail(String locationId) {
        return null;
    }

}
