package com.example.demo.entity;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Menu implements Serializable {
    private static final long serialVersionUID = -3867371155963210781L;
    private Integer id;
    private String name;
    private String roles;
    private String index;
}