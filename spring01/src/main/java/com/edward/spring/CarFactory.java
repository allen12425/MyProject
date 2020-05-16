package com.edward.spring;

public class CarFactory {
   public Car getCar1(String name) throws Exception{
        if (name.equals("audi")) {
            return new Audi();
        } else if (name.equals("bmw")) {
            return new Bmw();
        } else{
            throw new Exception("暂没有这种车");
        }
    }

    public static Car getCar(String name) throws Exception{
        if (name.equals("audi")) {
            return new Audi();
        } else if (name.equals("bmw")) {
            return new Bmw();
        } else{
            throw new Exception("暂没有这种车");
        }
    }
}
