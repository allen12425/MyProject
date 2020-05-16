package com.edward.springbootmybatis.service.impl;

import com.edward.springbootmybatis.dao.entity.User;
import com.edward.springbootmybatis.dao.mapper.UserMapper;
import com.edward.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }
}
