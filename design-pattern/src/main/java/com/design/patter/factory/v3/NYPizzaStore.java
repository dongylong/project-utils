package com.design.patter.factory.v3;


import com.design.patter.factory.model.enums.EPizzaTypeEnum;
import com.design.patter.factory.ingredient.NYPizzaIngredientFactory;
import com.design.patter.factory.ingredient.PizzaIngredientFactory;

public class NYPizzaStore extends PizzaStore {
    protected Pizza createPizza(EPizzaTypeEnum pizzaTypeEnum) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        switch (pizzaTypeEnum) {
            case CHEESE:
                pizza = new CheesePizza(ingredientFactory);
                pizza.setName("NY " + pizzaTypeEnum.getDesc());
                break;
            case CLAIM:
                pizza = new ClaimPizza(ingredientFactory);
                pizza.setName("NY " + pizzaTypeEnum.getDesc());

                break;
            case VEGGIE:
                pizza = new VeggiePizza(ingredientFactory);
                pizza.setName("NY " + pizzaTypeEnum.getDesc());
                break;
            default:
                break;
        }
        return pizza;
    }
}
