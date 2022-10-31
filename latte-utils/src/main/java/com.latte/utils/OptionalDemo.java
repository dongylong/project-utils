package com.latte.utils;

import java.util.Optional;
import java.util.stream.Stream;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> op = Optional.of("123");
        //11
        op.isEmpty();
//        op.ifPresentOrElse();
//        op.or();
        Stream<String> stream = op.stream();
        String s = op.orElseThrow();
    }
}
