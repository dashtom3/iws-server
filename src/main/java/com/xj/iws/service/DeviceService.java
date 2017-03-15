package com.xj.iws.service;

import com.xj.iws.utils.DataWrapper;

/**
 * Created by XiaoJiang01 on 2017/3/14.
 */
public interface DeviceService {
    DataWrapper<Void> start(String com);
}
