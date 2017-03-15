package com.xj.iws.http.service.manager;

import com.xj.iws.http.entity.SystemEntity;
import com.xj.iws.common.utils.DataWrapper;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/2/24.
 */
public interface SystemService {

    DataWrapper<Void> add(SystemEntity systemEntity);

    DataWrapper<Void> delete(int systemId);

    DataWrapper<Void> update(SystemEntity system);

    DataWrapper<List<SystemEntity>> list();

    DataWrapper<SystemEntity> detail(int systemId);
}
