package com.xj.iws.http.mvc.dao;

import com.xj.iws.http.mvc.entity.DataEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/4/6.
 */
@Repository
public interface DataDao {
    List<DataEntity> query(Map<String, String> conditions);

    List<DataEntity> presentData(@Param("deviceId") String deviceId, @Param("tableName")String tableName);
}
