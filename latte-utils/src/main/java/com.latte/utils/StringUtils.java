package com.latte.utils;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringUtils {

    public static void main(String[] args) {
        String str = "xx";
        jdk15_feature(str);
        jdk12_feature(str);
        jdk11_feature(str);
        jdk10_feature(str);
        jdk9_feature(str);
        jdk8_feature(str);
    }

    public static void jdk15_feature(String str) {
        //jdk 15
        str.stripIndent();
        str.translateEscapes();
        String formatted = str.formatted();
    }
    public static void jdk12_feature(String str) {
        //jdk12
        String indent = str.indent(1);
        Optional<String> s = str.describeConstable();
//        String ss = str.resolveConstantDesc(MethodHandles.Lookup);
//        str.transform();
    }
    public static void jdk11_feature(String str) {
        //11
        str.isBlank();
        str.strip();
        str.stripTrailing();
        str.stripLeading();
        Stream<String> lines = str.lines();
        long count = lines.count();
        String repeat = str.repeat(11);
    }
    public static void jdk10_feature(String str) {

    }

    public static void jdk9_feature(String str) {

        IntStream chars = str.chars();
        IntStream intStream = str.codePoints();

    }

    public static void jdk8_feature(String str) {
        String join = String.join(",", "222", "111");
        System.out.println(join);
    }
}
