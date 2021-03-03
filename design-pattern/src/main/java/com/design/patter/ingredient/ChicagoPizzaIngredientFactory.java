package com.design.patter.ingredient;


import com.design.patter.ingredient.model.*;
import com.design.patter.ingredient.model.source.*;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory{

    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    //莫泽雷勒干酪
    @Override
    public Cheese createCheese() {
        return new Mozzarella();
    }

    // BlackOlives 黑橄榄
    // Spinach 菠菜;
    // EggPlant 茄子
    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = {new BlackOlives(),new Spinach(),new EggPlant()};
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FrozenClams();
    }
}
