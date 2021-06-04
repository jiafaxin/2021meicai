package com.example.demo.prototype;

/**
 * 原型模式
 */
public class Client {
    public static void main(String[] args)throws Exception {
        Person person = new Person("jiafaxin","河南商丘",27);
        Car car = new Car("本田雅阁",0,person);
        Car newCar = (Car) car.clone();
        if(car.getPerson() == newCar.getPerson()){
            System.out.println("浅克隆!");
        }
        Car newCar1 = (Car) car.deepClone();
        if(car.getPerson() != newCar1.getPerson()){
            System.out.println("深克隆!");
        }
    }
}
