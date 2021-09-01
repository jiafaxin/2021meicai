package com.example.demo.netty;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIO {
    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8888);
        while(true){
            Socket socket = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    handle(socket);
                }
            });
        }
    }
    public static void handle(Socket socket){
        System.out.println("当前线程id为:"+Thread.currentThread().getId()+"线程名称："+Thread.currentThread().getName());
        byte[] array = new byte[1024];
        try {
            InputStream inputStream = socket.getInputStream();
            while (true){
                int read = inputStream.read(array);
                if(read != -1){
                    System.out.println(new String(array,"GBK"));
                }else{
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("socket关闭");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
