package com.edward.springboot.controller;

import com.edward.springboot.domain.User;
import com.edward.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserDao (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUsers")
    @ResponseBody
    public List<User> getUsers(Model model){
        List<User> list = userService.getUsers();
        return list;
    }

    @GetMapping("/test")
    public ModelAndView test(){
        List<User> list = userService.getUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users",list);
        modelAndView.setViewName("test");
        return modelAndView;
    }

    @PostMapping("/getUserById")
    public String getUserById(@RequestParam String id){
        User user = userService.getUserById(id);
        return "";
    }

    @PostMapping("/addUsers")
    public String AddUsers(@RequestBody User user){
        return "";
    }

}
