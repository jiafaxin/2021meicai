package com.example.demo.mq;

public class client {
    public static void main(String[] args) {
        Meaasge meaasge = new Meaasge();
        new Thread(new Producer(meaasge)).start();
        new Thread(new Customer(meaasge)).start();
        new Thread(new Customer(meaasge)).start();
        new Thread(new Customer(meaasge)).start();

    }
}
