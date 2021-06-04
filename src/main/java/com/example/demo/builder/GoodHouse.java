package com.example.demo.builder;

public class GoodHouse implements House {
    @Override
    public void buildDaDiJi() {
        System.out.println("好房子打10米的地基");
    }

    @Override
    public void buildWall() {
        System.out.println("好房子用好砖");
    }

    @Override
    public void buildFengDing() {
        System.out.println("好房子邀请好师傅封顶");
    }
}
