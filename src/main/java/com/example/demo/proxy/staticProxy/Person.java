package com.example.demo.proxy.staticProxy;

public class Person implements IPerson{
    @Override
    public void eat() {
        System.out.println("小明在吃甜甜圈!");
    }
}
