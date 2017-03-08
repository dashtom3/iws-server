package com.xj.iws.service;

import com.xj.iws.entity.SystemEntity;
import com.xj.iws.utils.DataWrapper;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/2/24.
 */
public interface SystemService {

    DataWrapper<Void> add(SystemEntity systemEntity);

    DataWrapper<Void> delete(String systemId);

    DataWrapper<Void> update(SystemEntity system);

    DataWrapper<List<SystemEntity>> list();

    DataWrapper<SystemEntity> detail(String key);
}
