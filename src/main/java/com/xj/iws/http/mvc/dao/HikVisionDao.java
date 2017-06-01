package com.xj.iws.http.mvc.dao;

import com.xj.iws.common.utils.Page;
import com.xj.iws.http.mvc.entity.HikVisionEntity;
import com.xj.iws.http.mvc.entity.util.Limitation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/5/27.
 */
@Repository
public interface HikVisionDao {
    int add(HikVisionEntity hikVision);

    int delete(int id);

    int update(HikVisionEntity hikVision);

    HikVisionEntity detail(int id);

    List<HikVisionEntity> list(@Param("roomId") String roomId,@Param("limit") List<Limitation> limit);

    List<HikVisionEntity> query(@Param("condition") Map<String, String> condition,@Param("page") Page page);

    int getCount(@Param("condition") Map<String, String> condition);
}
