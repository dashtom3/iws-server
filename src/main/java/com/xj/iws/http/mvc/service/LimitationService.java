package com.xj.iws.http.mvc.service;

import com.xj.iws.http.mvc.entity.UserEntity;

/**
 * Created by XiaoJiang01 on 2017/4/7.
 */
public interface LimitationService {
    boolean checkAdmin(UserEntity user);

    boolean checkSystem(UserEntity user,int systemId);

    boolean checkLimit(UserEntity user,int systemId,String areaId,int writable);

}
