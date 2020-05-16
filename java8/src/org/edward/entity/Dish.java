package org.edward.entity;

public class Dish {
    private Integer calories;
    private String name;
    private Type type;
    private final boolean vegetarian = false;
    public enum Type {MEAT,FISH,OTHER};

    public Dish(Integer calories, String name) {
        this.calories = calories;
        this.name = name;
    }

    public Dish(Integer calories, String name, Type type) {
        this.calories = calories;
        this.name = name;
        this.type = type;
    }

    public Dish() {
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
