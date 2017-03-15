package com.xj.iws.http.aop;


import org.aspectj.lang.JoinPoint;

/**
 * Created by XiaoJiang01 on 2017/3/15.
 */

public class AdminAspect {

    public void beforeMethod(JoinPoint point) {
        if(true){
            //重定向到自定义方法
        }else{
            //继续执行上级指定方法
        }
    }

    public void afterMethod(JoinPoint point) {

    }

    public void afterReturnMethod(JoinPoint point, Object result) {

    }

    public void afterThrowingMethod(JoinPoint point, Exception ex) {

    }
}
