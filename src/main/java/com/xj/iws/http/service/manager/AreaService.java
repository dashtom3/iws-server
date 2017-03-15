package com.xj.iws.http.service.manager;

import com.xj.iws.http.entity.area.AreaEntity;
import com.xj.iws.http.entity.area.CityEntity;
import com.xj.iws.http.entity.area.ProvinceEntity;
import com.xj.iws.common.utils.DataWrapper;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/8.
 */
public interface AreaService {
    DataWrapper<List<ProvinceEntity>> provinces();

    DataWrapper<List<ProvinceEntity>> cities();

    DataWrapper<List<ProvinceEntity>> areas();

    DataWrapper<ProvinceEntity> province(int provinceId);

    DataWrapper<CityEntity> city(int cityId);

    DataWrapper<AreaEntity> area(int areaId);
}
