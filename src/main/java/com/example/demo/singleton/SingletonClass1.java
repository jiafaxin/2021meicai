package com.example.demo.singleton;

/**
 * 饿汉式
 */
public class SingletonClass1 {

    private static final SingletonClass1 singletonClass = new SingletonClass1();

    private SingletonClass1(){

    }
    public static SingletonClass1 getSingletonClass(){
        return singletonClass;
    }
    public static void main(String[] args) {
        SingletonClass1 singletonClass = SingletonClass1.getSingletonClass();
        SingletonClass1 singletonClass1 = SingletonClass1.getSingletonClass();
        System.out.println(singletonClass == singletonClass1);
    }
}
