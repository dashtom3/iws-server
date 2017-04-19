package com.xj.iws.http.mvc.service;

import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.entity.DataEntity;
import com.xj.iws.http.mvc.entity.ViewDataEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/3/31.
 */
public interface DataService {

    DataWrapper<List<ViewDataEntity>> query(Map<String, String> conditions);

    DataWrapper<ViewDataEntity> presentData(String deviceId);
}
