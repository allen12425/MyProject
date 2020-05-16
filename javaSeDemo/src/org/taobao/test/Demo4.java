package org.taobao.test;

public class Demo4 {
    public static void main(String[] args) {
        //实例化是调用了构造方法
        Student per = new Student();
        per.display();
        Student per2 = new Student(1, "tom", 34);
        per2.display();
    }
}

class Student {
    //如果定义了有参的构造方法，那么默认的构成方法不再提供，除非手动定义无参构造方法
    //类默认会有一个无参的构造方法
    public Student() {
        System.out.println("Person");
        pid =1;
        name = "tom";
        age = 24;
    }
    //给实例变量赋初值
    public Student(int pid,String name,int age){
        this.pid = pid;
        this.name = name;
        this.age = age;
    }
    int pid;
    String name;
    int age;

    void display (){
        String msg = pid+","+name+","+age;
        System.out.println(msg);

    }
}
