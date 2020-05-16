package org.taobao.test;

public class Demo2 {
    //类是对象的模板，对象是类的具体实现
    public static void main(String[] args) {
        //code
        //实例化
        Person tom = new Person();
        tom.pid = 1;
        tom.name = "tom";
        tom.age = 24;
        tom.display();
        Person kite = new Person();
        kite.pid = 2;
        kite.name = "kite";
        kite.age = 26;
        kite.display();

    }
}

class CPU{

}
class ROM{

}
class Computer{
    CPU cpu;
    ROM rom;
}

class Car {

}

class Driver{
Car car;
int i=1;
}

class Person {
    //属性
    int pid;
    String name;
    int age;

    //构造方法
    public Person() {
    }

    void display() {
        String msg = pid + "," + name + "," + age;
        System.out.println(msg);
    }

    void buy(Car car){

    }
}
