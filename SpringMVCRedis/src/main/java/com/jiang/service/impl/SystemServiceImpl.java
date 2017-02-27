package com.jiang.service.impl;

import com.jiang.dao.SystemDao;
import com.jiang.entity.SystemEntity;
import com.jiang.service.SystemService;
import com.jiang.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/2/24.
 */

@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    SystemDao systemDao;

    @Override
    public DataWrapper<Void> add(SystemEntity systemEntity) {

        return null;
    }

    @Override
    public DataWrapper<Void> delete(SystemEntity systemEntity) {
        return null;
    }

    @Override
    public DataWrapper<Void> update(SystemEntity systemEntity) {
        return null;
    }

    @Override
    public DataWrapper<List<SystemEntity>> list(SystemEntity systemEntity) {
        return null;
    }
}
