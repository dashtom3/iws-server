package com.xj.iws.dao;

import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/3/1.
 */
public interface SystemDao {
    boolean add(Long score, Map value);
    Long getCount();
}
