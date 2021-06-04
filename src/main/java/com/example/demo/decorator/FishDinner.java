package com.example.demo.decorator;

public class FishDinner extends Dinner {


    @Override
    public String des() {
        return "烤鱼";
    }

    @Override
    public double price() {
        return 120.00d;
    }
}
