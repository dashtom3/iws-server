package com.xj.iws.dao;

import com.xj.iws.entity.area.AreaEntity;
import com.xj.iws.entity.area.CityEntity;
import com.xj.iws.entity.area.ProvinceEntity;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/8.
 */
public interface AreaDao {
    List<ProvinceEntity> provinces();

    List<CityEntity> cities(int provinceId);

    List<AreaEntity> areas(int cityId);

    ProvinceEntity province(int provinceId);

    CityEntity city(int cityId);

    AreaEntity area(int areaId);
}
