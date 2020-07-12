package com.company;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServiceMain {

    public static void main(String[] args) throws Exception {
        //实例化接口对象 要暴露给远程的方法/接口
        ISayService iSayService = new SayServiceImpl();
        //开启本地服务
        ISayService sayService = (ISayService) UnicastRemoteObject.exportObject(iSayService, 666);

        //服务注册中心
        Registry registry = LocateRegistry.createRegistry(999);
        //注册服务
        registry.rebind("sayService", sayService);
    }
}
