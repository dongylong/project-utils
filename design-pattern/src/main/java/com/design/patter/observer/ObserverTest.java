package com.design.patter.observer;

public class ObserverTest {
    public static void main(String[] args) {
        Subject subject = new WeatherDate();
        Observer observer = new CurrentConditionsDisplay(subject);
        observer.update(1,1,1);
        subject.registerObserver(observer);
        subject.notifyObservers();
    }
}
