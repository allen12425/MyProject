package org.allen.demo;

public class  Permission{
    public int public_i;
    private int private_i;
    protected int protected_i;
    int default_i;

    //同一个类里面都可以访问
    void test(){
        Permission a = new Permission();
        int r = a.default_i;
        r= a.private_i;
        r=a.protected_i;
        r = a.public_i;
    }

}
