package com.xj.iws.dao;

import com.xj.iws.entity.SystemEntity;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/6.
 */
public interface SystemDao {

    int add(SystemEntity system);

    int delete(String systemId);

    int update(SystemEntity system);

    List<SystemEntity> list();

    SystemEntity detail(String systemId);
}
