package com.latte.utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionUtils {

    /**
     * @SafeVarargs
     *  {@link java.util.Collections} addAll method
     *  开发人员确信使用变长度参数方法和泛型一起使用不会出错
     *  只能用在参数长度可变方法上
     *  且必须声明为static 或final
     * @param args
     * @param <T>
     * @return
     */
    @SafeVarargs
    public static <T> T useVarargs(T... args) {
        return args.length > 0 ? args[0] : null;
    }

    public static Map<Integer, List<ObjectDemo>> list2KeyListMap(List<ObjectDemo> demoList) {
        Map<Integer, List<ObjectDemo>> objectDemoMap = demoList.stream()
                .collect(Collectors.groupingBy(ObjectDemo::getNum));
        return objectDemoMap;
    }

    public static Map<Integer, ObjectDemo> list2Map(List<ObjectDemo> demoList) {
        Map<Integer, ObjectDemo> objectDemoMap = demoList.stream().
                collect(Collectors
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
}
