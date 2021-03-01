package com.design.patter.observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {


    private float temperature;
    private float humidity;

    private Subject weatherDate;

    public CurrentConditionsDisplay(Subject weatherDate) {
        this.weatherDate = weatherDate;
        weatherDate.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("tmp:" + temperature + ",humidity:" + humidity);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }
}
