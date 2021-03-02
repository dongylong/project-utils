package com.design.patter.factory.store;

import com.design.patter.factory.Pizza;
import com.design.patter.factory.model.city.ChicagoStyleCheesePizza;
import com.design.patter.factory.model.city.ChicagoStylePepperoniPizza;
import com.design.patter.factory.model.city.ChicagoStyleVeggiePizza;
import com.design.patter.factory.model.enums.EPizzaTypeEnum;

public class ChicagoPizzaStore extends PizzaStore{

    @Override
    public Pizza createPizza(EPizzaTypeEnum pizzaTypeEnum){
        Pizza pizza = null;
        switch (pizzaTypeEnum){
            case CHEESE:
                pizza = new ChicagoStyleCheesePizza();
                break;
            case CLAIM:
                pizza = new ChicagoStylePepperoniPizza();
                break;
            case VEGGIE:
                pizza = new ChicagoStyleVeggiePizza();
                break;
            default:
                break;
        }
        return pizza;
    }
}
