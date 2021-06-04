package com.example.demo.bridge;

/**
 * 桥接模式
 */
public class Client {

    public static void main(String[] args) {
        Phone phone = new Menory8G();
        Brand brand = new XiaomiBrand();
        phone.setBrand(brand);
        phone.getMemory();

    }
}
