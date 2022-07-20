package com.design.patter.factory.v2.city;

import com.design.patter.factory.v2.Pizza;

import java.util.Arrays;

public class ChicagoStyleClaimPizza extends Pizza {
    public ChicagoStyleClaimPizza() {
        this.setName("ChicagoStyleClaimPizza cheese pizza");
        this.setDough("ChicagoStyleClaimPizza dough");
        this.setSauce("ChicagoStyleClaimPizza Sauce");
        this.setToppings(Arrays.asList("ChicagoStyleClaimPizza toppings"));

    }
    public void cut() {
        System.out.println("ChicagoStyleClaimPizza cut");
    }

}
