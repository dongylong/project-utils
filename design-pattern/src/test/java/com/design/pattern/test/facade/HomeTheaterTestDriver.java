package com.design.pattern.test.facade;

import com.design.patter.facade.v1.*;

public class HomeTheaterTestDriver {
    public static void main(String[] args) {
        Amplifier amp = null;
        Tuner tuner = null;
        DvdPlayer dvd = null;
        CdPlayer cd = null;
        Projector projector = null;
        TheaterLights lights = null;
        Screen screen = null;
        PopcornPopper popper = null;
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(
                amp, tuner, dvd, cd, projector, lights, screen, popper
        );
        homeTheater.watchMovie("moon");
        homeTheater.endMovie();
    }
}
