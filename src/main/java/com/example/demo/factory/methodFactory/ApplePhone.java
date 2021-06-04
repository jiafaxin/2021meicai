package com.example.demo.factory.methodFactory;

public class ApplePhone implements Phone {
    @Override
    public void call() {
        System.out.println("苹果手机打电话");
    }
}
