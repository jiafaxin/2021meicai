package com.example.demo.decorator;

public class DosingDecorator extends Dinner {

    private Dinner dinner;

    public DosingDecorator(Dinner dinner){
        this.dinner = dinner;
    }

    @Override
    public String des() {
        return dinner.des();
    }

    @Override
    public double price() {
        return dinner.price();
    }
}
