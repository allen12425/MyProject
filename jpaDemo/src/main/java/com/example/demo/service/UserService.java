package com.example.demo.service;

import com.example.demo.common.Result;
import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUserByName(String name);
    Result addUser(User user);
}
