package com.edward.springboot.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private String userId;
    private String userName;
    private String address;
    private String telPhone;
    private String sex;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", telPhone='" + telPhone + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
