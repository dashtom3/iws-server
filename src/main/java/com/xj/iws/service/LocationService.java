package com.xj.iws.service;

import com.xj.iws.utils.DataWrapper;

/**
 * Created by XiaoJiang01 on 2017/2/27.
 */
public interface LocationService {

    DataWrapper delete(String locationId);

    DataWrapper update(String locationId, String locationName, String systemId, String blockId, String blockName);

    DataWrapper list(String name, String positationId, String systemId);

    DataWrapper detail(String locationId);

    DataWrapper add(String name, String positationX, String positationY, String positationId, String systemId, String blockId, String blockName);
}
