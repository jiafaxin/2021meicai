package com.example.demo.adapter;

import lombok.Data;

@Data
public class Adapter extends Voltage220V implements Voltage5V{

    private Voltage220V voltage220V;

    public Adapter(Voltage220V voltage220V){
        this.voltage220V = voltage220V;
    }

    @Override
    public int get5V() {
        int voltage = voltage220V.get220V()-215;
        return voltage;
    }
}
