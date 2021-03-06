package com.design.patter.command.v1;

import java.util.Arrays;

public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;

    public RemoteControl() {
        int num = 7;
        this.onCommands = new Command[num];
        this.offCommands = new Command[num];
        Command noCommand = new NoCommand();
        for (int i = 0; i < num; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }


    public void setCommand(int slot ,Command onCommand,Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }
    public void onButtonWasPushed(int slot ) {
        onCommands[slot].execute();
    }
    public void offButtonWasPushed(int slot ) {
        offCommands[slot].execute();
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
//        System.out.println(onCommands[0].getClass().getName());
        return "RemoteControl{" +
                "onCommands=" + Arrays.toString(onCommands) +
                ", offCommands=" + Arrays.toString(offCommands) +
                '}';
    }
}
