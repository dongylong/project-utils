package com.design.patter.template.v1;

public class TeaV1 {
    void prepareRecipe(){
        boilWater();
        steepTeaBag();
        pourInCup();
        addLemon();
    }

    private void pourInCup() {
        System.out.println("pourInCup");
    }

    private void steepTeaBag() {
        System.out.println("steepTeaBag");
    }

    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void addLemon() {
        System.out.println("addLemon");

    }
}
