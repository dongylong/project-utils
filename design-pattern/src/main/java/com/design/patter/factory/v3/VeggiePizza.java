package com.design.patter.factory.v3;

import com.design.patter.factory.ingredient.PizzaIngredientFactory;

public class VeggiePizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;

    public VeggiePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    void prepare() {
        System.out.println("prepare:" + this.getName());
        this.setDough(ingredientFactory.createDough());
        this.setSauce(ingredientFactory.createSauce());
        this.setCheese(ingredientFactory.createCheese());
    }
}
