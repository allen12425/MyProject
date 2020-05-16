package com.edward.entity;

import java.util.*;

public class Person {
    private String name;
    private int age;
    private Food food;
    private Properties gift;
    private List<String> list;
    private Map<String,String> map;
    private Set<String> set;
    private String [] str;

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Properties getGift() {
        return gift;
    }

    public void setGift(Properties gift) {
        this.gift = gift;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public String[] getStr() {
        return str;
    }

    public void setStr(String[] str) {
        this.str = str;
    }

    public Person(String name, int age, Food food) {
        this.name = name;
        this.age = age;
        this.food = food;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Person() {
        super();
        System.out.println("person ->init");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", food=" + food +
                '}';
    }
}
