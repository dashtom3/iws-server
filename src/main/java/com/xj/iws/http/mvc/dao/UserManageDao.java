package com.xj.iws.http.mvc.dao;

import com.xj.iws.http.mvc.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/3/21.
 */
@Repository
public interface UserManageDao {
    List<UserEntity> query(Map condition);

    int role(UserEntity userEntity);

    List<UserEntity> list();

    int status(UserEntity userEntity);
}
