package com.design.pattern.test.adapter.v1;

import com.design.patter.adapter.v1.Duck;
import com.design.patter.adapter.v1.MallardDuck;
import com.design.patter.adapter.v1.TurkeyAdapter;
import com.design.patter.adapter.v1.WildTurkey;

public class DuckTestDrive {
    public static void main(String[] args) {
        MallardDuck duck = new MallardDuck();
        WildTurkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);
        System.out.println("the turkey says...");
        turkey.gobble();
        turkey.fly();
        System.out.println("the duck says ..");
        testDuck(duck);
        System.out.println("TurkeyAdapter says");
        testDuck(turkeyAdapter);

    }

    private static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}
