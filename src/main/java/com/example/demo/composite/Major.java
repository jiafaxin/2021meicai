package com.example.demo.composite;

/**
 * 专业
 */
public class Major extends University {
    private String name;

    private String des;

    public Major(String name, String des) {
        this.name = name;
        this.des = des;
    }

    @Override
    public void outPut() {
        System.out.println("-----------------------专业------------------");
        System.out.println("名称:"+name + "描述"+des);
    }
}
