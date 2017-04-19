package com.xj.iws.http.mvc.service;

import com.xj.iws.common.utils.DataWrapper;
import com.xj.iws.http.mvc.entity.AlarmEntity;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/4/11.
 */
public interface AlarmService {
    DataWrapper<List<AlarmEntity>> list();
}
