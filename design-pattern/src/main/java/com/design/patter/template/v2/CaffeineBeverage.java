package com.design.patter.template.v2;

public abstract class CaffeineBeverage {
    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    protected abstract void addCondiments();

    void pourInCup(){
        System.out.println("pourInCup");
    }

    protected abstract void brew();

    void boilWater(){
        System.out.println("boilWater");
    }
}
