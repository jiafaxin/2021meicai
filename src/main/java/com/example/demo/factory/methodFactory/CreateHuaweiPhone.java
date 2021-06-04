package com.example.demo.factory.methodFactory;

public class CreateHuaweiPhone implements CreatePhone {

    @Override
    public Phone createPhone() {
        return new HuaweiPhone();
    }
}
