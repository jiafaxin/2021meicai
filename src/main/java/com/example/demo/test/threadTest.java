package com.example.demo.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 交替打印AB
 */
public class threadTest {
    private volatile static int count = 0;
    private volatile static boolean flag = true;
    public static void main(String[] args) {
        printAB();
    }


    private static void printAB(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            while(count <=100){
                if(flag){
                    System.out.println("A");
                    flag = false;
                    count++;
                }
            }
        });
        executorService.execute(()->{
            while(count <= 100){
                if(!flag){
                    System.out.println("B");
                    flag = true;
                    count++;
                }
            }
        });
    }
}
