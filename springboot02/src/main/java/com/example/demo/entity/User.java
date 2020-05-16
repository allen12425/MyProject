package com.example.demo.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private String userId;
    private String userName;
    private String password;
    private String address;
    private String telPhone;
    private String sex;
}