package com.xj.iws.dao;

import java.util.Map;
import java.util.Set;

/**
 * Created by XiaoJiang01 on 2017/2/28.
 */
public interface CommonDao {
    String addHash(String key, Map<String, String> value);
    String addSet(String key, String value);
    String updateHash(String key, Map<String, String> value);
    String deleteSet(String key, String value);
    String deleteKey(String key);
    Long getCount(String key);
    Set<String> getKey(String key);
    Map<String,String> getHash(String key);
    String getHashField(String key,String field);
}
