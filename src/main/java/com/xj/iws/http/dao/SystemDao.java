package com.xj.iws.http.dao;

import com.xj.iws.http.entity.SystemEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/6.
 */
@Repository
public interface SystemDao {

    int add(SystemEntity system);

    int delete(int systemId);

    int update(SystemEntity system);

    List<SystemEntity> list();

    SystemEntity detail(int systemId);

    List<String> pic();
}
