package com.xj.iws.http.mvc.dao;

import com.xj.iws.http.mvc.entity.AlarmEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/4/11.
 */
@Repository
public interface AlarmDao {
    List<AlarmEntity> list();
}
