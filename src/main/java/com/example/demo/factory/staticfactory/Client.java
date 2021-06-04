package com.example.demo.factory.staticfactory;

/**
 * 抽象工厂
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("----------------中国产的华为手机---------------------");
        CreateChinaPhone createChinaPhone = new CreateChinaPhoneImpl();
        ChinaHuaweiPhone chinaHuaweiPhone = createChinaPhone.createHuaweiPhone();
        chinaHuaweiPhone.call();

        System.out.println("----------------中国产的苹果手机---------------------");
        CreateChinaPhone createChinaPhone1 = new CreateChinaPhoneImpl();
        ChinaApplePhone chinaApplePhone =  createChinaPhone1.createApplePhone();
        chinaApplePhone.call();

        System.out.println("----------------美国产的华为手机---------------------");
        CreateUSAPhone createUSAPhone = new CreateUSAPhoneImpl();
        USAHuaweiPhone usaHuaweiPhone = createUSAPhone.createHuaweiPhone();
        usaHuaweiPhone.call();

        System.out.println("----------------美国产的苹果手机---------------------");
        CreateUSAPhone createUSAPhone1 = new CreateUSAPhoneImpl();
        USAApplePhone usaApplePhone = createUSAPhone1.createApplePhone();
        usaApplePhone.call();
    }
}
