package com.example.demo.factory.staticfactory;

public class USAHuaweiPhone implements ChinaPhone {
    @Override
    public void call() {
        System.out.println("美国产的华为手机打电话");
    }
}
