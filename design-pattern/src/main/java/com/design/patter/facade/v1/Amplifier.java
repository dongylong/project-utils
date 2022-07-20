package com.design.patter.facade.v1;

public interface Amplifier {
    void on();
    void setDvd(DvdPlayer dvdPlayer);
    void setSurroundSound();
    void setVolume(int level);

    void off();
}
