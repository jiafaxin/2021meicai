package com.example.demo.factory.staticfactory;

public class ChinaApplePhone implements ChinaPhone {
    @Override
    public void call() {
        System.out.println("中国产的苹果手机打电话");
    }
}
