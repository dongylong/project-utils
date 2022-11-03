package com.latte.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalDemo {
    public static void main(String[] args) {

    }


    public static void OptionalStream() throws MalformedURLException {
        Optional<List<String>> optional = Optional.ofNullable(new ArrayList<>(11));
        Stream<List<String>> stream = optional.stream();
        stream.flatMap(x -> x.stream()).forEach(System.out::println);
        var xx = new ArrayList<>();
        var url = new URL("xxx");
    }


    public static void jdk15_feature() {
        
    }
    public static void jdk11_feature() {
        Optional<String> op = Optional.of("123");
        //11
        op.isEmpty();
    }
    public static void jdk10_feature() {
        Optional<String> op = Optional.of("123");
        String s = op.orElseThrow();
    }
    public static void jdk9_feature() {
        Optional<String> op = Optional.of("123");
        //9
//        op.ifPresentOrElse();
        //9
//        op.or();
        //9
        Stream<String> stream = op.stream();
    }
}
