package com.design.patter.observer;

/**
 * 抽象观察者
 */
public interface Observer {
    void update(float temp,float humidity,float pressure);
}
