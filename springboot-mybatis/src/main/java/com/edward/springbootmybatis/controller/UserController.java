package com.edward.springbootmybatis.controller;

import com.edward.springbootmybatis.dao.entity.User;
import com.edward.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    @ResponseBody
    public List<User> getUsers() {
        List<User> users = userService.getAllUsers();
        return users;
    }


    @RequestMapping("/add")
    @ResponseBody
    public String  addUser() {
        User user = new User();
        user.setUserName("smith");
        user.setPassword("123456");
        user.setAddress("上海");
        user.setTelPhone("13564940349");
        user.setSex("0");
        userService.addUser(user);
        return "添加用户成功";
    }

}
