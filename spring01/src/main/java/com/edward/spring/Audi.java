package com.edward.spring;

public class Audi implements Car {

    @Override
    public String getName() {
        return "我是奥迪A7";
    }

    @Override
    public String getPrice() {
        return "700000";
    }
}
