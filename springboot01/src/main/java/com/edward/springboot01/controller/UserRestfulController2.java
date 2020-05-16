package com.edward.springboot01.controller;

import com.edward.springboot01.entity.User;
import com.edward.springboot01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.*;
@Controller
public class UserRestfulController2 {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("msg", "nihao~");
        //return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView getUserList(ModelMap map) {
        List<User> users = userService.getUserList();
        ModelAndView modelAndView = new ModelAndView();
        map.addAttribute("list",users);
        modelAndView.setViewName("user");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(User user) {
        String msg = userService.addUser(user);
        return msg;
    }

}
