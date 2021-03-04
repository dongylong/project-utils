package com.design.patter.factory.v2;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    String name;
    String dough;
    String  sauce;
    List toppings = new ArrayList<>();
    public void prepare() {
        System.out.println("prepare");
        System.out.println("name:"+name);
        System.out.println("dough:"+dough);
        System.out.println("sauce:"+sauce);
        System.out.println("toppings:"+toppings.toString());

    }

    public void bake() {
        System.out.println("bake");

    }

    public void cut() {
        System.out.println("cut");

    }

    public void box() {
        System.out.println("box");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDough() {
        return dough;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public List getToppings() {
        return toppings;
    }

    public void setToppings(List toppings) {
        this.toppings = toppings;
    }

}
