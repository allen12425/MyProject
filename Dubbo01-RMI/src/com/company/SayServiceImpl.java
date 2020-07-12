package com.company;

public class SayServiceImpl implements ISayService {

    @Override
    public String say(String name) throws Exception {

        System.out.println(name+"：hello");

        return name+"：hello";
    }
}
