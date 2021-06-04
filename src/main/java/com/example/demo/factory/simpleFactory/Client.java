package com.example.demo.factory.simpleFactory;

/**
 * 简单工厂
 */
public class Client {
    public static void main(String[] args) {
        Telphone telphone =  SimpleFactory.getCall("huawei");
        telphone.call();
    }
}
