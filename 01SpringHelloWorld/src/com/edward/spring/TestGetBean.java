package com.edward.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGetBean {
    public static void main(String[] args) {
//        Person p = new Person();
//        p.setAge(20);

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Person person = (Person) ctx.getBean("person");
//        Food food = ctx.getBean("food", Food.class);
//        food.setName("jack");
//        person.setName("张三");
//        person.setAge(18);
//        person.setFood(food);
//        System.out.println(person.toString());

        Person person = (Person) ctx.getBean("person");
        System.out.println(person.toString());
    }
}
