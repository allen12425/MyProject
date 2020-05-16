package com.edward.spring;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibFactory implements MethodInterceptor {
    private Object target;

    public CGLibFactory() {
    }

    public CGLibFactory(Object target) {
        this.target = target;
    }

    public Object createProxy() {
        Enhancer enhancer = new Enhancer();
        //继承被包装的类，创建子类，作为代理类
        enhancer.setSuperclass(Girl.class);
        //设置回调类
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("前");
        method.invoke(target, objects);
        System.out.println("后");
        return null;
    }
}
