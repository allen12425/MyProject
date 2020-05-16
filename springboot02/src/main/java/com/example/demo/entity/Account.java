package com.example.demo.entity;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Account implements Serializable {
    private static final long serialVersionUID = -3963551901153800965L;

    private int id;
    private String loginName;
    private String password;
    private String nickName;
    private Integer age;
    private String location;
    private String role;

}
