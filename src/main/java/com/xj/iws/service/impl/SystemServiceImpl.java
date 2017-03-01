package com.xj.iws.service.impl;

import com.xj.iws.enums.ErrorCodeEnum;
import com.xj.iws.service.SystemService;
import com.xj.iws.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by XiaoJiang01 on 2017/2/24.
 */

@Service
public class SystemServiceImpl implements SystemService {
    String table = "system";

    @Autowired
    CommonDao commonDao;

    /**
     * 添加系统
     *
     * @param name
     * @param pic
     * @return
     */
    @Override
    public DataWrapper<Void> add(String name, String pic) {

        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

        //格式化参数
        Map<String, String> value = new HashMap<String, String>();
        value.put("name", name);
        value.put("pic", pic);
        //获取编号
        Long num = commonDao.getCount("index_" + table) + 1;
        //生成key
        String key = "basic_" + table + "_" + num;
        //写入数据
        String result = commonDao.addHash(key, value);
        //添加索引
        if (key.equals(result)) {
            String s = commonDao.addSet("index_" + table, key);
            if (key.equals(s)) {
                dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
            }
        }
        return dataWrapper;
    }

    /**
     * @param systemId
     * @return
     */
    @Override
    public DataWrapper<Void> delete(String systemId) {

        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

        //删除数据
        String result = commonDao.deleteKey(systemId);
        //删除索引
        if (systemId.equals(result)) {
            String s = commonDao.deleteSet("index_" + table, systemId);
            if (systemId.equals(s)) {
                dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
            }
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> update(String systemId, String name, String pic) {

        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

        //格式化参数
        Map<String, String> value = new HashMap<String, String>();
        value.put("name", name);
        value.put("pic", pic);

        //写入数据
        String result = commonDao.updateHash(systemId, value);

        if (systemId.equals(result)) {
            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        }
        return dataWrapper;
    }

    /**
     * 获取系统列表
     *
     * @return
     */
    @Override
    public DataWrapper<List<Map<String, String>>> list() {

        DataWrapper<List<Map<String, String>>> dataWrapper = new DataWrapper<List<Map<String, String>>>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

//        //获取key
//        Set<String> systemKeys = commonDao.getKey("index_" + table);
//        //查询所有系统数据
//        if (systemKeys != null) {
//            List<Map<String, String>> data = new ArrayList<Map<String, String>>();
//            for (String key : systemKeys) {
//                Map<String, String> system = commonDao.getHash(key);
//                data.add(system);
//            }
//            if (data != null) {
//                dataWrapper.setData(data);
//                dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
//            }
//        }
        return dataWrapper;
    }

}
