package com.example.demo.factory.methodFactory;

/**
 * 工厂方法
 */
public class Client {

    public static void main(String[] args) {
        CreatePhone huaweiPhone = new CreateHuaweiPhone();
        Phone phone = huaweiPhone.createPhone();
        phone.call();
    }
}
