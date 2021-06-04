package com.example.demo.builder;

/**
 * 建造者模式
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("-----------------好房子-----------");
        HouseDirector houseDirector = new HouseDirector(new GoodHouse());
        houseDirector.createHouse();
        System.out.println("-----------------一般房子-----------");
        HouseDirector houseDirector1 = new HouseDirector(new BadHouse());
        houseDirector1.createHouse();
    }
}
