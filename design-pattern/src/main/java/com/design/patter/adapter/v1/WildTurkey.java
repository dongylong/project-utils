package com.design.patter.adapter.v1;

public class WildTurkey implements Turkey{

    @Override
    public void gobble() {
        System.out.println("Gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("i am flying a short distance");
    }
}
