package com.design.patter.factory.v2.city;

import com.design.patter.factory.v2.Pizza;

import java.util.Arrays;

public class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza() {
        this.setName("ChicagoStyleCheesePizza cheese pizza");
        this.setDough("ChicagoStyleCheesePizza dough");
        this.setSauce("ChicagoStyleCheesePizza Sauce");
        this.setToppings(Arrays.asList("ChicagoStyleCheesePizza toppings"));

    }

    public void cut() {
        System.out.println("ChicagoStyleCheesePizza cut");
    }

}
