package com.design.patter.observer;

/**
 * 抽象主题
 *
 */
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
