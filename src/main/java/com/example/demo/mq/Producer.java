package com.example.demo.mq;


public class Producer implements Runnable {
    private Meaasge message;
    public Producer(Meaasge message) {
        this.message = message;
    }

    @Override
    public void run() {
        while (true){
            synchronized (message){
                try {
                    message.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int i=0;i<5;i++){
                    message.sendMessage(i+"生产的消息");
                }
                System.out.println("Producer produced 5 messages.");
            }
        }

    }
}
