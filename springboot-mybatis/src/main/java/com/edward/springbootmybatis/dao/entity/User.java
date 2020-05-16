package com.edward.springbootmybatis.dao.entity;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long userId;
    private String userName;
    private String password;
    private String address;
    private String telPhone;
    private String sex;

}
