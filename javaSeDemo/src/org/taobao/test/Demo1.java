package org.taobao.test;

public class Demo1 {
    public static void main(String[] args) {
        System.out.println("hello");
        System.out.println(Demo1.test());
    }

    public static int test(){
        int num = 0;
        for (int i = 0; i < 10; i++) {
            if (i /2 == 2) {
                return i;
            }
        }
        return num;
    }
}
