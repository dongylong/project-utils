package com.latte.utils;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class CollectionUtils {




    public static void jdk10_feature() {
        //集合新增创建不可变集合的方法

    }
    public static void jdk9_feature() {
        //of 关键字
        List<String> list = List.of("a", "b", "c");
        Set<String> set = Set.of("a", "b", "c");
        Map<String, Integer> map1 = Map.of("Tom", 12, "Jerry", 21, "Lilei", 33, "HanMeimei", 18);
        Map.Entry<String, Integer> tom = Map.entry("Tom", 89);
        Map.Entry<String, Integer> jim = Map.entry("Jim", 78);
        Map.Entry<String, Integer> tim = Map.entry("Tim", 98);
        Map<String, Integer> map2 = Map.ofEntries(tom, jim, tim);
    }


    /**
     * @param args
     * @param <T>
     * @return
     * @SafeVarargs {@link java.util.Collections} addAll method
     * 开发人员确信使用变长度参数方法和泛型一起使用不会出错
     * 只能用在参数长度可变方法上
     * 且必须声明为static 或final
     */
    @SafeVarargs
    public static <T> T useVarargs(T... args) {
        return args.length > 0 ? args[0] : null;
    }

    public <K, V extends Comparable<? super V>> Map<K, V> sortByValueReversed(Map<K, V> map) {
        Map<K, V> result = new LinkedHashMap<>();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.<K, V>comparingByValue().reversed())
                .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        return result;
    }

    public <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        Map<K, V> result = new LinkedHashMap<>();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.<K, V>comparingByValue())
                .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        return result;
    }

    public static Map<Integer, List<ObjectDemo>> list2KeyListMap(List<ObjectDemo> demoList) {
        Map<Integer, List<ObjectDemo>> objectDemoMap = demoList.stream()
                .collect(Collectors.groupingBy(ObjectDemo::getNum));
        return objectDemoMap;
    }

    /**
     * 按照String 排序
     */
    public static void compareListStringProperty() {
        List<ObjectDemo> demoList = new ArrayList<>();
        demoList.sort((o1, o2) -> o1.getStr().compareTo(o2.getStr()));
        demoList.sort(Comparator.comparing(ObjectDemo::getStr));
        demoList.sort(comparing(ObjectDemo::getStr));

    }

    public static Map<Integer, ObjectDemo> list2Map(List<ObjectDemo> demoList) {
        Map<Integer, ObjectDemo> objectDemoMap = demoList.stream()
                .collect(Collectors
                        .toMap(ObjectDemo::getNum, a -> a, (v1, v2) -> v2));
        return objectDemoMap;
    }

    public static List<Integer> listClass2ListProperty(List<ObjectDemo> demoList) {
        List<Integer> nums = demoList.stream()
                .map(ObjectDemo::getNum)
                .collect(Collectors.toList());
        return nums;
    }

    public static String map2String(Map<String, ObjectDemo> objectDemoMap) {
        String demoNames = objectDemoMap.values().stream()
                .map(ObjectDemo::getStr)
                .collect(Collectors.joining(","));
        return demoNames;
    }


    public static Long listCount(List<ObjectDemo> demoList) {
        Long count = demoList.stream().distinct().count();
        return count;
    }


    /**
     * 并行求和
     *
     * @param values
     * @return
     */
    private int addIntegers(List<Integer> values) {
        return values.parallelStream().mapToInt(i -> i).sum();
    }

}
