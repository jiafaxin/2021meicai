package com.example.demo.proxy.jdkProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy {

    private IPerson iPerson;

    public JDKProxy(IPerson iPerson) {
        this.iPerson = iPerson;
    }

    public Object getProxyInstace(){
        return  Proxy.newProxyInstance(iPerson.getClass().getClassLoader(),
                iPerson.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("jdk动态代理开始");
                        Object invoke = method.invoke(iPerson, args);
                        System.out.println("jdk动态代理结束");
                        return invoke;
                    }
                });
    }
}
