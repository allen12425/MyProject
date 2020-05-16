package com.edward.springbootmybatis.service;

import com.edward.springbootmybatis.dao.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void addUser(User user);
}
