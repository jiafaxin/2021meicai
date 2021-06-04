package com.example.demo.proxy.staticProxy;

public class Client {
    public static void main(String[] args) {
        IPerson person = new Person();

        StaticProxy staticProxy = new StaticProxy(person);
        staticProxy.eat();
    }
}
