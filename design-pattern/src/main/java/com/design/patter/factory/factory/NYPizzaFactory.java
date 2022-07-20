package com.design.patter.factory.factory;

import com.design.patter.factory.model.enums.EPizzaTypeEnum;
import com.design.patter.factory.v2.Pizza;
import com.design.patter.factory.v2.city.NYStyleCheesePizza;
import com.design.patter.factory.v2.city.NYStylePepperoniPizza;
import com.design.patter.factory.v2.city.NYStyleVeggiePizza;
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
