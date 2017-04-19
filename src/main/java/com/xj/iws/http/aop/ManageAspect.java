package com.xj.iws.http.aop;


import com.xj.iws.common.sessionManager.SessionManager;
import org.aspectj.lang.JoinPoint;

/**
 * Created by XiaoJiang01 on 2017/3/15.
 */

public class ManageAspect {

    public void beforeMethod(JoinPoint point) {
        Object[] param = point.getArgs();
        String token = null;
        for (int i = 0; i <param.length ; i++) {
            if(param[i].toString().length() > 1){
                if ("SK".equals(param[i].toString().substring(0,2))){
                    token = param[i].toString();
                    break;
                }
            }
        }
        if (!"SK123".equals(token))
        if(10 != SessionManager.getSession(token).getStatus()){
            try {
                throw new ExDataWrapper();
            } catch (ExDataWrapper e) {
                e.printStackTrace();
            }
        }
    }
}
