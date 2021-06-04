package com.example.demo.command;

/**
 * 命令模式
 */
public class Client {
    public static void main(String[] args) {
        RemoteController remoteController = new RemoteController();
        Light light= new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);
        remoteController.setCommand(lightOnCommand,lightOffCommand);
        remoteController.open();
        remoteController.off();

    }
}
