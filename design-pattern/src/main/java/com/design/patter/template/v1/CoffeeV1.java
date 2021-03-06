package com.design.patter.template.v1;

public class CoffeeV1 {
    void prepareRecipe(){
        boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addSugarAndMilk();
    }

    private void pourInCup() {
        System.out.println("pourInCup");
    }

    private void brewCoffeeGrinds() {
        System.out.println("brewCoffeeGrinds");
    }

    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void addSugarAndMilk() {
        System.out.println("addSugarAndMilk");

    }
}
