package com.xj.iws.http.mvc.dao;

import com.xj.iws.http.mvc.entity.area.AreaEntity;
import com.xj.iws.http.mvc.entity.area.CityEntity;
import com.xj.iws.http.mvc.entity.area.ProvinceEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/8.
 */
@Repository
public interface AreaDao {

    List<ProvinceEntity> provinces();

    List<CityEntity> cities(int provinceId);

    List<AreaEntity> areas(int cityId);

    ProvinceEntity province(int provinceId);

    CityEntity city(int cityId);

    AreaEntity area(int areaId);
}
