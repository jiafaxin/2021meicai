package com.example.demo.factory.simpleFactory;

public class SimpleFactory {

    public static Telphone getCall(String type){
        Telphone telphone = null;
        if("huawei".equals(type)){
            telphone = new Huawei();
        }else if("phone".equals(type)){
            telphone = new Phone();
        }
        return telphone;
    }
}
