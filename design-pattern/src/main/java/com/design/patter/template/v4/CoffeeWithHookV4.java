package com.design.patter.template.v4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeWithHookV4 extends CaffeineBeverageWithHookV4 {

    @Override
    protected void addCondiments() {
        System.out.println("adding sugar and milk");

    }

    @Override
    protected void brew() {
        System.out.println("CoffeeWithHookV4 brew");
    }

    boolean customerWantsCondiments() {
        String answer = getUserInput();
        if (answer.toLowerCase().startsWith("y")) {
            return true;
        }
        return false;
    }

    private String getUserInput() {
        String answer = "";
        System.out.println("add sugar? y/n");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try{
            answer =  in.readLine();
        }catch (IOException e) {
            e.printStackTrace();
            return "no";
        }
        return answer;
    }
}
