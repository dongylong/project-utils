package com.design.patter.factory;

import com.design.patter.factory.model.city.*;
import com.design.patter.factory.model.enums.EPizzaStyleEnum;
import com.design.patter.factory.model.enums.EPizzaTypeEnum;
import com.design.patter.factory.v2.Pizza;
import com.design.patter.factory.v2.city.*;

public class DependentPizzaStore {
    public Pizza createPizza(EPizzaStyleEnum styleEnum, EPizzaTypeEnum typeEnum){
        Pizza pizza = null;
        switch (styleEnum){
            case NY:
                switch (typeEnum){
                    case CHEESE:
                        pizza = new NYStyleCheesePizza();
                        break;
                    case VEGGIE:
                        pizza = new NYStyleVeggiePizza();
                        break;
                    case PEPPERONI:
                        pizza = new NYStylePepperoniPizza();
                        break;
                }
                break;
            case CHICAGO:
                switch (typeEnum){
                    case CHEESE:
                        pizza = new ChicagoStyleCheesePizza();
                        break;
                    case VEGGIE:
                        pizza = new ChicagoStyleVeggiePizza();
                        break;
                    case PEPPERONI:
                        pizza = new ChicagoStylePepperoniPizza();
                        break;
                }
                break;
            default:
                System.out.println("valid type");
                break;
        }
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
