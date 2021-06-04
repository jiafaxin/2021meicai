package com.example.demo.bridge;

public class Memory4G extends Phone {

    @Override
    void getMemory() {
        brand.getBrandName();
        System.out.println("4G内存的");
    }
}
