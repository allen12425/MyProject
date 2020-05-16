package com.edward.springboot.service;

import com.edward.springboot.domain.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUserById(String id);

    void addUser(User user);
}
