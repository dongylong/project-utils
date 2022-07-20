package com.design.patter.command.v1;

public class TestRemoteControl {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        GarageDoor garageDoor = new GarageDoor();
        GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);
        remote.setSlot(lightOnCommand);
        remote.buttonWasPressed();
        remote.setCommand(garageDoorOpenCommand);
        remote.buttonWasPressed();

    }
}
