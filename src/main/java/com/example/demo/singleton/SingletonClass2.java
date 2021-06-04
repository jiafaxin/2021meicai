package com.example.demo.singleton;

/**
 * 双重校验式
 */
public class SingletonClass2 {

    private static volatile SingletonClass2 singletonClass2 = null;

    private SingletonClass2(){

    }
    public static SingletonClass2 getSingletonClass2(){
        if(null == singletonClass2){
            synchronized (SingletonClass2.class){
                if(null == singletonClass2){
                    singletonClass2 = new SingletonClass2();
                }
            }
        }
        return singletonClass2;
    }
    public static void main(String[] args) {
        SingletonClass2 singletonClass = SingletonClass2.getSingletonClass2();
        SingletonClass2 singletonClass1 = SingletonClass2.getSingletonClass2();
        System.out.println(singletonClass == singletonClass1);
    }
}
