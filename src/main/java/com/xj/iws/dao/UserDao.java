package com.xj.iws.dao;

import com.xj.iws.entity.UserEntity;

/**
 * Created by XiaoJiang01 on 2017/2/27.
 */
public interface UserDao {

    UserEntity getUserByUsername(String username);

    UserEntity getUserById(int id);

    int updateUser(UserEntity user);

    int updatePwd(UserEntity user);

    int register(UserEntity newUser);
}
