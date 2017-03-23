package com.xj.iws.http.service;

import com.xj.iws.common.utils.DataWrapper;

/**
 * Created by XiaoJiang01 on 2017/3/14.
 */
public interface DeviceService {
    DataWrapper<Void> start(String com);
}
