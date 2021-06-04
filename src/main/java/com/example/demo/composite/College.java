package com.example.demo.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 学院
 */
public class College extends University {
    private String name;

    private String des;

    List<University> list = new ArrayList<>();

    public College(String name, String des) {
        this.name = name;
        this.des = des;
    }

    @Override
    public void add(University university) {
        list.add(university);
    }

    @Override
    public void outPut() {
        System.out.println("-----------------------学院------------------");
        System.out.println("名称:"+name + "描述"+des);
        for(University university:list){
            university.outPut();
        }
    }
}
