package org.allen.demo.extend;

public class Dog extends Animal {
    void test(){
        super.pid = 100;
        super.display();
    }
    public Dog(){
        //super();//调用父类默认的构造方法

        //如果父类没有默认的构造方法，必须显示的调用父类的构造方法
        super(1,"tom",18);
        System.out.println("Dog.....");
    }
    void test2(){
        System.out.println("Dog  汪汪");
    }
}
