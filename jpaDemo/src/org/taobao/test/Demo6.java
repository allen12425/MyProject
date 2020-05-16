package org.taobao.test;

public class Demo6 {
    public static void main(String[] args) {
        Teacher te1 = new Teacher();
        System.out.println(te1.pid + "," + te1.age);
        Teacher te2 = new Teacher();
        System.out.println(te2.pid + "," + te2.age);
        Teacher.m1();
    }

/**
 * 1.1放在变量前面
 * 称为静态变量，或者类变量
 * 为该类的公共变量，对所有对象来说只有一份
 * 1.2放在方法前面
 * 称为静态方法，或者类方法
 * 在调用该方法时，不会将对象的引用传递给他
 * 所以static方法不能访问非static成员
 * 1.3可以通过对象引用或者类名（不需要实例化）访问static成员
 * 1.4单例模式
 */
}

class Teacher {

    //static的变量是所有对象共享的
    static int pid;
    int age;

    public Teacher() {
        pid++;
        age++;
    }

    static void m1() {
        //age = 100;
        //m2();
    }

    void m2() {

    }

}
