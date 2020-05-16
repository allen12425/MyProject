package org.allen.demo.extend;

public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setName("huahua");
        dog.setAid(1);
        dog.setAge(23);

        dog.display();
        dog.test2();
    }
}
