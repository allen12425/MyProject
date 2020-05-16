package com.edward.spring;

public class Bmw implements Car {
    @Override
    public String getName() {
        return "BMW 7";
    }

    @Override
    public String getPrice() {
        return "800000";
    }
}
