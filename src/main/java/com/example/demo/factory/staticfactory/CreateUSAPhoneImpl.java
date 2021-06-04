package com.example.demo.factory.staticfactory;

public class CreateUSAPhoneImpl implements CreateUSAPhone {
    @Override
    public USAApplePhone createApplePhone() {
        return new USAApplePhone();
    }

    @Override
    public USAHuaweiPhone createHuaweiPhone() {
        return new USAHuaweiPhone();
    }
}
