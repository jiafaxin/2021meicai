package com.example.demo.facade;

public class Refrigerator {

    private Refrigerator(){}
    private static final Refrigerator intance = new Refrigerator();

    public static Refrigerator getInstance(){
        return intance;
    }
    public void on(){
        System.out.println("冰箱门打开");
    }
    public void off(){
        System.out.println("冰箱门关闭");
    }
}
