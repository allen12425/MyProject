package com.edward.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class MainController {

    /**
     * String 类型的返回值会找模板文件
     *
     * @return
     */
    @RequestMapping(value = "/list")
    public String list() {
        return "user";
    }


    /**
     * String 类型的返回值会找模板文件
     *
     * @return
     */
    @RequestMapping(value = "/test")
    public String list(ModelMap map) {
        map.put("userName","tom");
        map.addAttribute("id",1);
        return "test";
    }
}
