package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User,Integer> {
    @Query("select s from User s where s.userName like CONCAT('%',:username,'%')")
    User findByName(@Param("username")String name);
}
