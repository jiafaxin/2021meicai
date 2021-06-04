package com.example.demo.bridge;

/**
 * 这时候手机相当于一个桥，把内存和品牌关联在一起
 */
public abstract class Phone {

    protected Brand brand;

    public void setBrand(Brand brand){
        this.brand = brand;
    }

    abstract void getMemory();
}
