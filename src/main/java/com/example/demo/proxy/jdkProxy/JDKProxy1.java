package com.example.demo.proxy.jdkProxy;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy1 implements InvocationHandler {

    private IPerson iPerson;

    public JDKProxy1(IPerson iPerson) {
        this.iPerson = iPerson;
    }
    public Object getInstance(){
        return Proxy.newProxyInstance(iPerson.getClass().getClassLoader(),iPerson.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk动态代理1开始");
        Object invoke = method.invoke(iPerson, args);
        System.out.println("jdk动态代理1结束");
        return invoke;
    }
}
