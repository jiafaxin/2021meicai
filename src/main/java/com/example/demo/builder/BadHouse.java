package com.example.demo.builder;

public class BadHouse implements House{
    @Override
    public void buildDaDiJi() {
        System.out.println("一般房子打5米的地基");
    }

    @Override
    public void buildWall() {
        System.out.println("一般房子用一般的砖");
    }

    @Override
    public void buildFengDing() {
        System.out.println("一般房子邀请一般的师傅封顶");
    }
}
