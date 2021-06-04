package com.example.demo.facade;

/**
 * 外观模式
 */
public class Client {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.one();
        facade.two();
        facade.three();
    }
}
