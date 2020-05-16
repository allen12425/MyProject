package org.edward.entity;

public class Apple {
    private Integer aid;
    private String color;
    private Double weight;

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }
    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() >150;
    }

    public Apple(String color, Double weight) {
        this.color = color;
        this.weight = weight;
    }

    public Apple(Integer aid, String color) {
        this.aid = aid;
        this.color = color;
    }

    public Apple(Integer aid) {
        this.aid = aid;
    }

    public Apple() {
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
