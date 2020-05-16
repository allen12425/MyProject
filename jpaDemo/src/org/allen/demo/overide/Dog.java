package org.allen.demo.overide;

public class Dog extends Animal {
    //方法的覆盖，子类里面有一个和父类同名方法Override
    //方法的重载，在同一个类里面，方法名称相同，参数的个数或者类型不同

    @Override
    public void run() {
       /// super.run();
        System.out.println("Dog run.....");
    }

}
