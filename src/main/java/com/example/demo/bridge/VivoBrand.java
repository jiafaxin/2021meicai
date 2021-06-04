package com.example.demo.bridge;

public class VivoBrand implements Brand {
    @Override
    public void getBrandName() {
        System.out.println("Vivo 品牌的手机");
    }
}
