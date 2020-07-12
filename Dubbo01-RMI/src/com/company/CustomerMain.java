package com.company;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CustomerMain {
    public static void main(String[] args) throws Exception{
        //创建注册中心
        Registry registry = LocateRegistry.createRegistry(999);
        //发现服务
        ISayService sayService = (ISayService) registry.lookup("sayService");

        String str = sayService.say("如雪");
        System.out.println(str);
    }
}
