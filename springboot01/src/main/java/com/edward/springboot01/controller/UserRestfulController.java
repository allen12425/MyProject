package com.edward.springboot01.controller;

import com.edward.springboot01.entity.User;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RequestMapping("/")
@RestController
    public class UserRestfulController {

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());
    @RequestMapping(value="/User",method= RequestMethod.GET)
    public List<User> getUserList(){
        List<User> list = new ArrayList<>(users.values());
        return 	list;

    }

    @RequestMapping(value="User",method=RequestMethod.POST)
    public String addUser(@ModelAttribute User user) {
        users.put(user.getId(), user);
        return "addUser Success";
    }
}
