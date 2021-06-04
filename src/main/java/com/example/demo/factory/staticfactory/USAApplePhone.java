package com.example.demo.factory.staticfactory;

public class USAApplePhone implements ChinaPhone {
    @Override
    public void call() {
        System.out.println("美国产的苹果手机打电话");
    }
}
