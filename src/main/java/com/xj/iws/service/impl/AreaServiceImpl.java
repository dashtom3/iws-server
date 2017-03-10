package com.xj.iws.service.impl;

import com.xj.iws.dao.AreaDao;
import com.xj.iws.entity.SystemEntity;
import com.xj.iws.entity.area.AreaEntity;
import com.xj.iws.entity.area.CityEntity;
import com.xj.iws.entity.area.ProvinceEntity;
import com.xj.iws.enums.CallStatusEnum;
import com.xj.iws.enums.ErrorCodeEnum;
import com.xj.iws.service.AreaService;
import com.xj.iws.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XiaoJiang01 on 2017/3/8.
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    AreaDao areaDao;

    @Override
    public DataWrapper<List<ProvinceEntity>> provinces() {
        DataWrapper<List<ProvinceEntity>> dataWrapper = new DataWrapper<List<ProvinceEntity>>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

        //查询全部省份
        List<ProvinceEntity> provinces = areaDao.provinces();

        if (provinces != null) {
            dataWrapper.setData(provinces);
            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        }

        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<ProvinceEntity>> cities() {
        DataWrapper<List<ProvinceEntity>> dataWrapper = new DataWrapper<List<ProvinceEntity>>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

        //查询全部省份
        List<ProvinceEntity> provinces = areaDao.provinces();

        //遍历查询省份下全部城市，按省份分类
        for (ProvinceEntity province : provinces) {
            List<CityEntity> cities = areaDao.cities(province.getProvinceId());
            province.setCity(cities);
        }
        if (provinces != null) {
            dataWrapper.setData(provinces);
            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        }
        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<ProvinceEntity>> areas() {
        DataWrapper<List<ProvinceEntity>> dataWrapper = new DataWrapper<List<ProvinceEntity>>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

        //查询全部省份
        List<ProvinceEntity> provinces = areaDao.provinces();

        //遍历查询省份下全部城市，按省份分类
        for (ProvinceEntity province : provinces) {
            List<CityEntity> cities = areaDao.cities(province.getProvinceId());
            //遍历查询城市下全部地区，按城市分类
            for (CityEntity city : cities) {
                List<AreaEntity> areas = areaDao.areas(city.getCityId());
                city.setArea(areas);
            }
            province.setCity(cities);
        }
        if (provinces != null) {
            dataWrapper.setData(provinces);
            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        }
        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }

    @Override
    public DataWrapper<ProvinceEntity> province(int provinceId){
        DataWrapper<ProvinceEntity> dataWrapper = new DataWrapper<ProvinceEntity>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

        //获取省份信息
        ProvinceEntity province = areaDao.province(provinceId);
        //获取省份下全部城市
        List<CityEntity> citis = areaDao.cities(provinceId);
        province.setCity(citis);

        if (province != null) {
            dataWrapper.setData(province);
            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        }

        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }

    @Override
    public DataWrapper<CityEntity> city(int cityId){
        DataWrapper<CityEntity> dataWrapper = new DataWrapper<CityEntity>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

        //获取城市信息
        CityEntity city = areaDao.city(cityId);
        //获取城市所在省份信息
        ProvinceEntity province = areaDao.province(city.getProvinceId());
        //获取城市下所有地区
        List<AreaEntity> areas = areaDao.areas(cityId);

        city.setProvince(province);
        city.setArea(areas);

        if (city != null) {
            dataWrapper.setData(city);
            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        }

        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }

    @Override
    public DataWrapper<AreaEntity> area(int areaId){
        DataWrapper<AreaEntity> dataWrapper = new DataWrapper<AreaEntity>();
        dataWrapper.setErrorCode(ErrorCodeEnum.Error);

        //获取地区信息
        AreaEntity area = areaDao.area(areaId);
        //获取地区所在城市信息
        CityEntity city = areaDao.city(area.getCityId());
        //获取地区所在省份信息
        ProvinceEntity province = areaDao.province(city.getProvinceId());

        city.setProvince(province);
        area.setCity(city);

        if (area != null) {
            dataWrapper.setData(area);
            dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
        }

        dataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return dataWrapper;
    }
}