package org.taobao.test;

public class Demo7 {
    public static void main(String[] args) {
        //单例模式：一个类只能创建一个对象（只能有一个实例）
        Demo d1 = Demo.getInstance();
        Demo d2 = Demo.getInstance();
        System.out.println(d1 == d2);//true
    }
}

class Demo {
    //构造方法要是私有的
    private Demo() {

    }

    private static Demo instance = null;
    //最初级的懒汉式
    public static Demo getInstance() {
        if (instance == null) {
        //自己实例化自己
            instance = new Demo();
        }
        return instance;
    }
}
