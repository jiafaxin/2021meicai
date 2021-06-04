package com.example.demo.factory.staticfactory;

public class CreateChinaPhoneImpl implements  CreateChinaPhone{
    @Override
    public ChinaApplePhone createApplePhone() {
        return new ChinaApplePhone();
    }

    @Override
    public ChinaHuaweiPhone createHuaweiPhone() {
        return new ChinaHuaweiPhone();
    }
}
