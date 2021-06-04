package com.example.demo.decorator;

public class Kelp extends DosingDecorator {

    public Kelp(Dinner dinner) {
        super(dinner);
    }
    @Override
    public String des() {
        return super.des()+"加上海带了";
    }

    @Override
    public double price() {
        return super.price()+10.00d;
    }

}
