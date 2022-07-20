package com.design.patter.command.v1;

public class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl() {
    }

    public SimpleRemoteControl(Command slot) {
        this.slot = slot;
    }
    void buttonWasPressed(){
        slot.execute();
    }

    public Command getSlot() {
        return slot;
    }

    public void setSlot(Command slot) {
        this.slot = slot;
    }

    public void setCommand(Command slot) {
        this.slot = slot;
    }
}
