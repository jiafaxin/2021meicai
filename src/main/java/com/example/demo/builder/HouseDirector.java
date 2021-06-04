package com.example.demo.builder;

public class HouseDirector {

    private House house;

    public HouseDirector(House house){
        this.house = house;
    }

    public void createHouse(){
         house.buildDaDiJi();
         house.buildWall();
         house.buildFengDing();
    }
}
