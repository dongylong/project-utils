package com.design.patter.factory.model.city;

import com.design.patter.factory.Pizza;

import java.util.Arrays;

public class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        this.setName("NYStyleCheesePizza pizza");
        this.setDough("NYStyleCheesePizza dough");
        this.setSauce("NYStyleCheesePizza Sauce");
        this.setToppings(Arrays.asList("NYStyleCheesePizza toppings"));
    }
}
