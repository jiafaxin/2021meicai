package com.example.demo.factory.staticfactory;

public class ChinaHuaweiPhone implements ChinaPhone {
    @Override
    public void call() {
        System.out.println("中国产的华为手机打电话");
    }
}
