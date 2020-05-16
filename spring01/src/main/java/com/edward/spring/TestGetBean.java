package com.edward.spring;

import com.edward.entity.Person;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGetBean {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
       /* Car car = new CarFactory().getCar("audi");
        System.out.println(car.getName());*/

        Car car1 = ctx.getBean("car1",Car.class);
        System.out.println(car1.hashCode());
        System.out.println(car1.getName());
        System.out.println(car1.getPrice());

        Car car12 = ctx.getBean("car1",Car.class);
        System.out.println(car12.hashCode());
        System.out.println(car12.getName());
        System.out.println(car12.getPrice());

        Car car = ctx.getBean("car", Car.class);
        System.out.println(car.hashCode());
        System.out.println(car.getName());
        System.out.println(car.getPrice());

        Car car2 = ctx.getBean("car", Car.class);
        System.out.println(car2.hashCode());
        System.out.println(car2.getName());
        System.out.println(car2.getPrice());




    }

}
