package com.example.demo.singleton;

/**
 * 静态内部类
 */
public class SingletonClass3 {

    private SingletonClass3(){}

    private static class getSingletonClass3Holder{
        private static SingletonClass3 singletonClass3 = new SingletonClass3();
    }
    public static SingletonClass3 getInstance(){
        return getSingletonClass3Holder.singletonClass3;
    }
    public static void main(String[] args) {
        SingletonClass3 singletonClass = SingletonClass3.getInstance();
        SingletonClass3 singletonClass1 = SingletonClass3.getInstance();
        System.out.println(singletonClass == singletonClass1);
    }
}
