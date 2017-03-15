package com.xj.iws.http.service.user;

import com.xj.iws.http.entity.UserEntity;
import com.xj.iws.common.utils.DataWrapper;

/**
 * Created by XiaoJiang01 on 2017/2/27.
 */
public interface UserService {

    DataWrapper<UserEntity> login(String userName, String password);

    DataWrapper<UserEntity> register(UserEntity user, String code);

    DataWrapper<Void> getVerifyCode(String phone);

    DataWrapper<UserEntity> detail(int userId);

    DataWrapper<UserEntity> update(UserEntity user);

    DataWrapper<Void> changePwd(int userId, String oldPwd, String newPwd);

    DataWrapper<Void> forgetPwd(String username, String password, String code);

    DataWrapper<Void> reLogin(String token);
}
