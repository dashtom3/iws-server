package com.jiang.controller;

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
public class Test {

    @RequestMapping("test")
    public ModelAndView test(String test){
        System.out.print("controller");
        Map model = new HashMap();
        model.put("test",test);
        ModelAndView modelAndView = new ModelAndView("ok",model);
        return modelAndView;
    }
}
