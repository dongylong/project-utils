package com.design.pattern.factory.test;

import com.design.patter.factory.Pizza;
import com.design.patter.factory.model.enums.EPizzaTypeEnum;
import com.design.patter.factory.store.ChicagoPizzaStore;
import com.design.patter.factory.store.NYPizzaStore;
import com.design.patter.factory.store.PizzaStore;

public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();
        Pizza nyPizza = nyStore.orderPizza(EPizzaTypeEnum.CHEESE);
        Pizza chicagoPizza = chicagoStore.orderPizza(EPizzaTypeEnum.CHEESE);
        System.out.println(nyPizza.getName());
        System.out.println(chicagoPizza.getName());

    }
}
