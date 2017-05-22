package com.xj.iws.http.mvc.dao;

import com.xj.iws.common.utils.Page;
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
    List<DataEntity> query(@Param("condition") Map<String, String> condition,@Param("page") Page page);

    List<DataEntity> presentData(@Param("deviceId") int deviceId, @Param("tableName")String tableName);

    List<Map<String,String>> pumpStatus(@Param("deviceId") int deviceId, @Param("tableName")String tableName);

    int getCount(Map<String, String> condition);
}
