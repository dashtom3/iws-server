package com.jiang.service;

import com.jiang.entity.LocationEntity;
import com.jiang.utils.DataWrapper;

/**
 * Created by XiaoJiang01 on 2017/2/27.
 */
public interface LocationService {
    DataWrapper add(LocationEntity locationEntity);

    DataWrapper delete(LocationEntity locationEntity);

    DataWrapper update(LocationEntity locationEntity);

    DataWrapper list(LocationEntity locationEntity);

    DataWrapper detail(LocationEntity locationEntity);

}
