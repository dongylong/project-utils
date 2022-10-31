package com.latte.utils;

import java.util.stream.Stream;

public class StringUtilDemo {

    public static void main(String[] args) {
        String str = "xx";
        //11
        str.isBlank();
        str.strip();
        str.stripTrailing();
        str.stripLeading();
        //jdk 15
        str.stripIndent();
        Stream<String> lines = str.lines();
        long count = lines.count();
    }
}
