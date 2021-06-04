package com.example.demo.template;

public abstract class Person {

    abstract void qichuang();

    abstract void eat();

    abstract void xiaban();

    abstract void sleep();

    void oneday(){
        qichuang();
        eat();
        xiaban();
        sleep();
    }
}
