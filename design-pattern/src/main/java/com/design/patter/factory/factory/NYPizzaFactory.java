package com.design.patter.factory.factory;

import com.design.patter.factory.model.enums.EPizzaTypeEnum;
import com.design.patter.factory.Pizza;
import com.design.patter.factory.model.city.NYStyleCheesePizza;
import com.design.patter.factory.model.city.NYStylePepperoniPizza;
import com.design.patter.factory.model.city.NYStyleVeggiePizza;
import com.design.patter.factory.store.PizzaStore;

public class NYPizzaFactory extends PizzaStore {

    @Override
    public Pizza createPizza(EPizzaTypeEnum pizzaTypeEnum) {
        Pizza pizza = null;
        switch (pizzaTypeEnum){
            case CHEESE:
                pizza = new NYStyleCheesePizza();
                break;
            case CLAIM:
                pizza = new NYStylePepperoniPizza();
                break;
            case VEGGIE:
                pizza = new NYStyleVeggiePizza();
                break;
            default:
                break;
        }
        return pizza;
    }
}
