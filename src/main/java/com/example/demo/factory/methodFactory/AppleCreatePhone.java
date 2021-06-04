package com.example.demo.factory.methodFactory;

public class AppleCreatePhone implements CreatePhone {
    @Override
    public Phone createPhone() {
        return new ApplePhone();
    }
}
