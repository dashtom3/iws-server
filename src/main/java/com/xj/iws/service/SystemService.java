package com.xj.iws.service;

import com.xj.iws.utils.DataWrapper;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/2/24.
 */
public interface SystemService {
    
    DataWrapper<Void> add(String name, String pic);

    DataWrapper<Void> delete(String systemId);

    DataWrapper<Void> update(String systemId, String name, String pic);

    DataWrapper<List<Map<String, String>>> list();

}
