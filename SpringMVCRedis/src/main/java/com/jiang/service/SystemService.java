package com.jiang.service;

import com.jiang.entity.SystemEntity;
import com.jiang.utils.DataWrapper;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/2/24.
 */
public interface SystemService {

    DataWrapper<Void> add(SystemEntity systemEntity);

    DataWrapper<Void> delete(SystemEntity systemEntity);

    DataWrapper<Void> update(SystemEntity systemEntity);

    DataWrapper<List<SystemEntity>> list(SystemEntity systemEntity);

    DataWrapper<SystemEntity> detail(SystemEntity systemEntity);
}
