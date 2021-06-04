package com.example.demo.composite;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 大学
 */
@Data
public class HeNanUniversity extends University {

    private String name;

    private String des;

    List<University> list = new ArrayList<>();

    public HeNanUniversity(String name, String des) {
        this.name = name;
        this.des = des;
    }

    @Override
    public void add(University university) {
        list.add(university);
    }

    @Override
    public void outPut() {
        System.out.println("-----------------------大学------------------");
        System.out.println("名称:"+name + "描述"+des);
        for(University university:list){
            university.outPut();
        }
    }
}
