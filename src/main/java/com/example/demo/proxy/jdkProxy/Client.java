package com.example.demo.proxy.jdkProxy;



public class Client {
    public static void main(String[] args) {
        IPerson person = new Person();
        IPerson proxyInstace = (IPerson) new JDKProxy(person).getProxyInstace();
        proxyInstace.eat();

        IPerson instance = (IPerson) new JDKProxy1(person).getInstance();
        instance.eat();
    }
}
