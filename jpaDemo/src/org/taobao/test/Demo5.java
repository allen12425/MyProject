package org.taobao.test;

public class Demo5 {
    public static void main(String[] args) {
        Teach te = new Teach();
        te.pid = 1;
        te.name = "tom";
        te.age = 34;
        te.display();

        Teach te2 = new Teach();
        te2.pid = 2;
        te2.name = "kite";
        te2.age = 21;
        te2.display();

        Teach te3 = new Teach(3, "rose", 22);
        te3.display();

        Teach te4 = te3.getInstance();
        te4.display();
    }
}

class Teach {
    int pid;
    String name;
    int age;

    public Teach() {
        System.out.println("Teach");
    }

    public Teach(int pid) {
        System.out.println("teach pid....");
        this.pid = pid;
    }

    public Teach getInstance(){
        this.pid=100;
        this.name = "jack";
        this.age = 30;
        return this;
    }

    //this代表当前对象的引用
    public Teach(int pid, String name, int age) {
        this(pid);
        //this();
        //this.pid = pid;
        this.name = name;
        this.age = age;
    }

    void display() {
        String msg = pid + "," + name + "," + age;
        System.out.println(msg);
    }
}