package com.design.patter.factory.v2.city;

import com.design.patter.factory.v2.Pizza;

import java.util.Arrays;

public class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        this.setName("NYStyleCheesePizza pizza");
        this.setDough("NYStyleCheesePizza dough");
        this.setSauce("NYStyleCheesePizza Sauce");
        this.setToppings(Arrays.asList("NYStyleCheesePizza toppings"));
    }
}
