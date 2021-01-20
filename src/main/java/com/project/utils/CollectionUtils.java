package com.project.utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionUtils {

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
