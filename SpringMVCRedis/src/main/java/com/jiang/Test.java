package com.jiang;

import com.jiang.dao.impl.TestDao;

/**
 * Created by XiaoJiang01 on 2017/2/15.
 */
public class Test {
    public static void main(String[] arg0) {
        System.out.println(new TestDao().set("asd"));
        System.out.println("ok");
        System.out.println(new TestDao().get());
    }
}
