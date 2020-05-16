package com.edward.springboot01.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private Long id;
    private String loginName;
    private String password;
    private String nickName;
}
