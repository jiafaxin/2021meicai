package com.example.demo.factory.methodFactory;

public class HuaweiPhone implements Phone {
    @Override
    public void call() {
        System.out.println("华为手机打电话");
    }
}
