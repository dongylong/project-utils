package com.design.patter.template.v2;

public class TeaV2 extends CaffeineBeverage{


    @Override
    protected void addCondiments() {
        System.out.println("addLemon");
    }

    @Override
    protected void brew() {
        System.out.println("tea brew ");
    }

}
