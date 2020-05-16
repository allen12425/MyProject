package com.edward.springbootmybatis.dao.mapper;

import com.edward.springbootmybatis.dao.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> getAllUsers();
    void addUser(User user);
}
