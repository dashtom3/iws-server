package com.xj.iws.http.mvc.dao;

import com.xj.iws.http.mvc.entity.LocationEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/3/3.
 */
@Repository
public interface LocationDao {
    List<LocationEntity> list(int systemId);

    int add(LocationEntity locationEntity);

    int delete(int locationId);

    int update(LocationEntity locationEntity);

    LocationEntity detail(int locationId);

    List<LocationEntity> query(Map<String,String> condition);
}
