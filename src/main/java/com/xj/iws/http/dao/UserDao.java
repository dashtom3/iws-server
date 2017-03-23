package com.xj.iws.http.dao;

import com.xj.iws.http.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by XiaoJiang01 on 2017/2/27.
 */
@Repository
public interface UserDao {

    UserEntity getUserByUsername(String username);

    UserEntity getUserById(int id);

    int updateUser(UserEntity user);

    int updatePwd(UserEntity user);

    int register(UserEntity newUser);
}
