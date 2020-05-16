package com.example.demo.service.impl;

import com.example.demo.common.CustomException;
import com.example.demo.common.Result;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUsers() {
        return userDao.findAll();
    }

    @Override
    public User getUserByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public Result addUser(User user) {
        try {
            User userResult = userDao.save(user);
            return Result.success("注册用户成功",userResult);
        } catch (Exception e) {
            throw new CustomException("注册用户出现异常",e);
        }
    }
}
