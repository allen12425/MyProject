package com.edward.springboot01.service;

import com.edward.springboot01.entity.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    Map<Long, User> mapSyn = Collections.synchronizedMap(new HashMap<Long,User>());
    public List<User> getUserList() {
        Map<Long,User> map = new HashMap<Long,User>();
        for (long i = 0; i < 5; i++) {
            map.put(i,new User(i,"tom"+i,"1234","tom"));
        }

        Map<Long, User> mapSyn = Collections.synchronizedMap(map);
        List<User> list = new ArrayList<>(mapSyn.values());
        return list;
    }

    public String addUser(User user) {
        mapSyn.put(user.getId(),user);
        return "add user success";
    }

}
