package com.xj.iws.common.sessionManager;

import com.xj.iws.http.mvc.entity.UserEntity;

/**
 * Created by XiaoJiang01 on 2017/3/15.
 */
public class AdminManager {

    public static boolean adminCheck(String key){
        UserEntity user = SessionManager.getSession(key);
        if (user.getStatus() > 9){
            return true;
        }else {
            return false;
        }
    }
}
