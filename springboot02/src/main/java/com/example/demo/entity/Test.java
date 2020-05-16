package com.example.demo.entity;

import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String date = "2020-05";
        String pattern = "^\\d{4}\\D+\\d{2}$";
        boolean flag = Pattern.matches("^\\d{4}\\D+\\d{2}$",date);
        System.out.println(flag);
    }
}
