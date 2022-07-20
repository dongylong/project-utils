package com.design.patter.factory.ingredient;


import com.design.patter.factory.v3.sauce.abstarct.factory.*;

public interface PizzaIngredientFactory {
    Dough createDough();

    Sauce createSauce();

    Cheese createCheese();

    Veggies[] createVeggies();

    Pepperoni createPepperoni();

    Clams createClam();
}
