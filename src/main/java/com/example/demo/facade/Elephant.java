package com.example.demo.facade;

public class Elephant {

    private Elephant(){}
    private static final Elephant intance = new Elephant();

    public static Elephant getInstance(){
        return intance;
    }

    public void into(){
        System.out.println("大象进冰箱");
    }
    public void output(){
        System.out.println("大象出冰箱");
    }
}
