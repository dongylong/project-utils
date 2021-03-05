package com.design.patter.facade.v1;

public interface Projector {
    void on();
    void setInput(DvdPlayer dvdPlayer);
    void wideScreenMode();

    void off();
}
