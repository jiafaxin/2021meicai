package com.example.demo.mq;

import java.util.ArrayList;
import java.util.List;


public class Meaasge {

    List<String> list = new ArrayList<>();

    public boolean Empty(){
        return list.isEmpty();
    }

    public void sendMessage(String msg){
        System.out.println("生产者的消息");
        list.add(msg);

    }

    public String cousmerMessage(){

        return list.remove(0);
    }
}
