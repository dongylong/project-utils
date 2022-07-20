package com.design.patter.factory.store;

import com.design.patter.factory.model.enums.EPizzaTypeEnum;
import com.design.patter.factory.v2.Pizza;

public abstract class PizzaStore {

    public Pizza orderPizza(EPizzaTypeEnum pizzaTypeEnum) {
        Pizza pizza = createPizza(pizzaTypeEnum);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    protected abstract Pizza createPizza(EPizzaTypeEnum pizzaTypeEnum);
}
