package com.jiang.controller;

import com.jiang.dao.impl.TestDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by XiaoJiang01 on 2017/2/15.
 */
@Controller
@RequestMapping("/")
public class TestController {

    @RequestMapping("testController")
    public ModelAndView test(String test){
        Map model = new HashMap();

        TestDao testDao = new TestDao();
        testDao.set(test);
        String a = testDao.get();

        model.put("test",a);
        ModelAndView modelAndView = new ModelAndView("ok",model);
        return modelAndView;
    }
}
