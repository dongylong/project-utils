package com.design.patter.template.v5;

import java.util.Arrays;

public class TestDuckSortDrive {
    public static void main(String[] args) {
        DuckV5[] duckV5s = {
                new DuckV5("1", 1),
                new DuckV5("5", 5),
                new DuckV5("8", 8),
                new DuckV5("2", 2),
                new DuckV5("55", 55),
                new DuckV5("22", 22)
        };
        System.out.println("before");
        display(duckV5s);
        Arrays.sort(duckV5s);
        System.out.println("after");

        display(duckV5s);

    }

    private static void display(DuckV5[] duckV5s) {
        for (DuckV5 duckV5 : duckV5s) {
            System.out.println(duckV5);
        }
    }
}
