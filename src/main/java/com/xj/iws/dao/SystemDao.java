package com.xj.iws.dao;

import com.xj.iws.entity.SystemEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/3/1.
 */
public interface SystemDao {

    boolean add(Long score, SystemEntity value);

    boolean delete(String id);

    void update(SystemEntity system);

    Map<String, String> detail(String key);

    List<Map<String,String>> list(String... q);

    Long getCount();
}
