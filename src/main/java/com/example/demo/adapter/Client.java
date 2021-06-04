package com.example.demo.adapter;

/**
 * 适配器模式
 */
public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new Adapter(new Voltage220V()));
    }
}
