package com.design.patter.factory.factory;

import com.design.patter.factory.v2.Pizza;
import com.design.patter.factory.v2.city.ChicagoStyleCheesePizza;
import com.design.patter.factory.v2.city.ChicagoStylePepperoniPizza;
import com.design.patter.factory.v2.city.ChicagoStyleVeggiePizza;
import com.design.patter.factory.model.enums.EPizzaTypeEnum;
import com.design.patter.factory.store.PizzaStore;

public class ChicagoPizzaFactory extends PizzaStore {

    @Override
    public Pizza createPizza(EPizzaTypeEnum pizzaTypeEnum) {
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
