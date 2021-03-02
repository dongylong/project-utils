package com.design.patter.factory.factory;

import com.design.patter.factory.Pizza;
import com.design.patter.factory.model.*;
import com.design.patter.factory.model.enums.EPizzaTypeEnum;

public class SimplePizzaFactory {
    public Pizza createPizza(EPizzaTypeEnum pizzaTypeEnum){
        Pizza pizza = null;
       switch (pizzaTypeEnum){
           case CHEESE:
               pizza = new CheesePizza();
               break;
           case CLAIM:
               pizza = new PepperoniPizza();
               break;
           case VEGGIE:
               pizza = new VeggiePizza();
               break;
           default:
               break;
        }
    return pizza;
    }
}
