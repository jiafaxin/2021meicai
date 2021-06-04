package com.example.demo.command;

public class RemoteController {

    private Command onCommand;
    private Command offCommand;

    public void setCommand(Command onCommand,Command offCommand){
        this.onCommand = onCommand;
        this.offCommand = offCommand;
    }
    public void open(){
        onCommand.execute();
    }
    public void off(){
        offCommand.execute();
    }
}
