package com.example.demo.mq;

public class Customer implements Runnable {
    private Meaasge message;
    public Customer(Meaasge message) {
        this.message = message;
    }

    @Override
    public void run() {
        while (true){
            synchronized (message){
                if(message.Empty()){
                    message.notify();
                }else{
                    String cousmerMessage = message.cousmerMessage();
                    System.out.println("Customer consumed message: " + cousmerMessage + ".");
                }
            }
        }

    }
}
