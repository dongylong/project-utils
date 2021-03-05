package com.design.patter.adapter.v1;

public class MallardDuck implements Duck{
    @Override
    public void quack() {
        System.out.println("quack");
    }

    @Override
    public void fly() {
        System.out.println("i am flying");

    }
}
