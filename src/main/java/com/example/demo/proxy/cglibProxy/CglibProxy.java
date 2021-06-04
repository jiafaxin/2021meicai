package com.example.demo.proxy.cglibProxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private Person person;

    public CglibProxy(Person person) {
        this.person = person;
    }
    public Object getInstance(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(person.getClass());
        enhancer.setCallback(this);
        Object o = enhancer.create();
        return o;
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib动态代理开始");
        Object invoke = method.invoke(person, objects);
        System.out.println("cglib动态代理结束");
        return invoke;
    }
}
