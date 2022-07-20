package com.design.patter.facade.v1;

public interface DvdPlayer {
    void on();
    void play(String movie);

    void stop();

    void eject();

    void off();
}
