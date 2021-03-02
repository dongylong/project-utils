package com.design.patter.factory.model.city;

import com.design.patter.factory.Pizza;

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
