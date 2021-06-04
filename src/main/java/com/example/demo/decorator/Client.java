package com.example.demo.decorator;


/**
 * 装饰者模式
 */
public class Client {


    public static void main(String[] args) {
        Dinner dinner = new FishDinner();
        System.out.println(dinner.des()+"销售价格："+dinner.price());

        dinner = new Kelp(dinner);
        System.out.println(dinner.des()+"销售价格："+dinner.price());
    }
}
