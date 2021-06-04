package com.example.demo.factory.simpleFactory;

public class Phone implements Telphone {
    @Override
    public void call() {
        System.out.println("苹果手机打电话");
    }
}
