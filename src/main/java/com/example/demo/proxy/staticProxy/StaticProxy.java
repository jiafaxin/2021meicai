package com.example.demo.proxy.staticProxy;

public class StaticProxy implements IPerson{

    private IPerson iPerson;

    public StaticProxy(IPerson iPerson) {
        this.iPerson = iPerson;
    }

    @Override
    public void eat() {
        System.out.println("静态代理开始");
        iPerson.eat();
        System.out.println("静态代理结束");
    }
}
