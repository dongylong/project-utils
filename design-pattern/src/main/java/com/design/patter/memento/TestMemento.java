package com.design.patter.memento;

public class TestMemento {
    public static void main(String[] args) {
        Original original = new Original("ddd");
        Store store = new Store(original.createMemento());
        System.out.println("1...."+original.getValue());
        original.setValue("eeee");
        System.out.println("2...."+original.getValue());
        original.restoreMemento(store.getMemento());
        System.out.println("3...."+original.getValue());
    }
}
