package com.xj.iws.service.impl;

import com.xj.iws.service.UserService;
import com.xj.iws.utils.DataWrapper;
import org.springframework.stereotype.Service;

/**
 * Created by XiaoJiang01 on 2017/2/27.
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public DataWrapper login(String userName, String password) {
        return null;
    }

    @Override
    public DataWrapper register(String userName, String password, String name) {
        return null;
    }

    @Override
    public DataWrapper detail(String userId) {
        return null;
    }

    @Override
    public DataWrapper update(String userId, String name, String pic) {
        return null;
    }

    @Override
    public DataWrapper updatePwd(String userId, String password) {
        return null;
    }

    @Override
    public DataWrapper reLogin(String userId) {
        return null;
    }
}
