package com.design.patter.template.v2;

public class CoffeeV2  extends CaffeineBeverage{


    @Override
    protected void addCondiments() {
        System.out.println("add milk");
    }

    @Override
    protected void brew() {
        System.out.println("CoffeeV2 brew ");
    }

}
