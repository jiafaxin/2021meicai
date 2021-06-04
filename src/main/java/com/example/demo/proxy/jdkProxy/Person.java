package com.example.demo.proxy.jdkProxy;


public class Person implements IPerson{
    @Override
    public void eat() {
        System.out.println("小红在吃甜甜圈!");
    }
}
