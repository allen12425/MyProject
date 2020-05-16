package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/getUser")
    @ResponseBody
    public User geUserByName(String name) {
        User user = userService.getUserByName(name);
        return user;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<User> geUsers() {
        List<User> users = userService.getUsers();
        return users;
    }

    @GetMapping("/register")
    public String register(){
        System.out.println("======get======");
        return "register";
    }

    @PostMapping("/register")
    public String registerP(@ModelAttribute User user, ModelMap map){
        System.out.println("====post=====");
        Result result = userService.addUser(user);
        map.addAttribute("result",result);
        return "register";
    }

    @PostMapping("/login")
    public String login(){
        return "login";
    }

}
