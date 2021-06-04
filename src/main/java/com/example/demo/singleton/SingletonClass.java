package com.example.demo.singleton;

/**
 * 懒汉式
 */
public class SingletonClass {

    private static SingletonClass singletonClass;

    private SingletonClass(){

    }
    public static synchronized SingletonClass getSingletonClass(){
        if(null == singletonClass){
            singletonClass = new SingletonClass();
        }
        return singletonClass;
    }

    public static void main(String[] args) {
        SingletonClass singletonClass = SingletonClass.getSingletonClass();
        SingletonClass singletonClass1 = SingletonClass.getSingletonClass();
        System.out.println(singletonClass == singletonClass1);
    }
}
