package org.taobao.test;

public class Demo3 {
    public static void main(String[] args) {
        //System.out.println("*");
        //打印10次
        //体现方法的重用性
        Demo3.printStart(10);
        new Demo3().m1();
    }

    /**
     * 有static关键字的方法称为静态方法或类方法
     *
     * @param n
     */
    public static void printStart(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("*");
        }
    }

    //方法必须放到类的里面定义，不能单独定义，封装特性体现
    //没有static修饰的方法为非静态方法或实例方法
    void m1() {
        System.out.println("这是一个非静态方法");
    }

    //方法的重载 overloading
    //方法重载：方法名称相同，参数列表不同（包括参数的类型，个数，顺序）,
    //但不能根据返回值是否相同来判断是否是重载
    static int sum() {
        int i = 1;
        int j = 2;
        return i + j;
    }

    static int sum(int i, int j) {
        return i + j;
    }
    //虽然返回值类型不同，但是会报sum方法已存在、
    //所以不能仅根据返回值类型来判断是否是重载
  /*  static String sum(){
        return "";
    }*/

    //方法的重写是子类继承父类或实现某个接口，然后子类重写父类的方法
    //方法名，参数列表，返回值都要相同，但子类的方法访问权限不能小于父类的。
}



