package com.design.patter.template.v5;

public class DuckV5 implements Comparable{
    private String name;
    private int weight;

    public DuckV5(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "DuckV5{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        DuckV5 otherDuct = (DuckV5) o;
        if(this.weight< otherDuct.weight){
            return -1;
        }else if(this.weight == otherDuct.weight){
            return 0;
        }
        return 1;
    }
}
