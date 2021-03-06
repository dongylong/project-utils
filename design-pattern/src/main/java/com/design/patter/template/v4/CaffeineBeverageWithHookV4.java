package com.design.patter.template.v4;

public abstract class CaffeineBeverageWithHookV4 {

    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        if(customerWantsCondiments()) {
            addCondiments();
        }
    }

    boolean customerWantsCondiments(){
        return true;
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
