package org.allen.demo.extend;

public class Animal {
    private int aid;
    private String name;
    private int age;

    protected int pid;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
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

  /*  public Animal(){
        System.out.println("Animal...");
    }*/

    public Animal(int aid, String name, int age) {
        System.out.println("Animal.....");
        this.aid = aid;
        this.name = name;
        this.age = age;
    }

    void display(){
        String msg = aid+","+name+","+"age";
        System.out.println(msg);
    }
}
