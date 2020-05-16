package com.edward.spring;

public class TestGetBean2 {

    public static void main(String[] args) throws Exception {
        Girl girl = new Girl();
        Girl proxyGirl = (Girl) new CGLibFactory(girl).createProxy();

        proxyGirl.eat();
        System.out.println("========");
        proxyGirl.bath();
    }

}
