package com.xj.iws.service;

import com.xj.iws.entity.LocationEntity;
import com.xj.iws.utils.DataWrapper;

/**
 * Created by XiaoJiang01 on 2017/2/27.
 */
public interface LocationService {

    DataWrapper add(LocationEntity locationEntity);

    DataWrapper delete(String locationId);

    DataWrapper update(LocationEntity location);

    DataWrapper list(String systemId, String positationId);

    DataWrapper detail(String locationId);
}
