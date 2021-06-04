package com.example.demo.facade;

public class Facade {

    private Elephant elephant;

    private Refrigerator refrigerator;

    public Facade() {
        this.elephant = Elephant.getInstance();
        this.refrigerator = Refrigerator.getInstance();
    }
    public void one(){
        refrigerator.on();
    }

    public void two(){
        elephant.into();
    }

    public void three(){
        elephant.output();
        refrigerator.off();
    }
}
