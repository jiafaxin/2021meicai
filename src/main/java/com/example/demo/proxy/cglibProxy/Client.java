package com.example.demo.proxy.cglibProxy;

public class Client {
    public static void main(String[] args) {
        Person person = new Person();
        Person instance = (Person) new CglibProxy(person).getInstance();
        instance.eat();
    }
}
