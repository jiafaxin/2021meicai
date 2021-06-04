package com.example.demo.template;

public class Xiaoming extends Person {
    @Override
    void qichuang() {
        System.out.println("小明起床");
    }

    @Override
    void eat() {
        System.out.println("小明吃饭");
    }

    @Override
    void xiaban() {
        System.out.println("小明下班");
    }

    @Override
    void sleep() {
        System.out.println("小明睡觉");
    }
}
