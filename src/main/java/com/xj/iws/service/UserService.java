package com.xj.iws.service;

import com.xj.iws.utils.DataWrapper;

/**
 * Created by XiaoJiang01 on 2017/2/27.
 */
public interface UserService {
    DataWrapper login(String userName, String password);

    DataWrapper register(String userName, String password, String name);

    DataWrapper detail(String userId);

    DataWrapper update(String userId, String name, String pic);

    DataWrapper updatePwd(String userId, String password);

    DataWrapper reLogin(String userId);
}
