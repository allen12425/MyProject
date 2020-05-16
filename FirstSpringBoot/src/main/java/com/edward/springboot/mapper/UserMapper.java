package com.edward.springboot.mapper;

import com.edward.springboot.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> getUsers();

    User getUserById(String id);

    void addUser(@Param("user") User user);
}
