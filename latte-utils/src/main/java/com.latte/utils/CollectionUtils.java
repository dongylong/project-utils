package com.latte.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class CollectionUtils {


    public static void main(String[] args) {
//        streamNullDemo();
        listNullDemo();
    }

    public static void OptionalStream() throws MalformedURLException {
        Optional<List<String>> optional = Optional.ofNullable(new ArrayList<>(11));
        Stream<List<String>> stream = optional.stream();
        stream.flatMap(x -> x.stream()).forEach(System.out::println);
        var xx = new ArrayList<>();
        var url = new URL("xxx");
    }

    public static void streamIteratorDemo() {
        Stream.iterate(1, i -> i + 1).limit(10).forEach(System.out::println);
        Stream.iterate(1, i -> i < 100, i -> i + 1).forEach(System.out::println);

    }

    public static void listNullDemo() {
        List<String> list = new ArrayList<>();
        list.add("AA");
        list.add(null);
        //不报异常
        System.out.println(list.stream().count());
        List<String> list1 = new ArrayList<>();
        list1.add(null);
        //不报异常
        System.out.println(list1.stream().count());
    }

    public static void streamOfNullAbleDemo() {
        Stream<String> stringStream = Stream.of("AA", "BB", null);
        //3
        System.out.println(stringStream.count());
        Stream<String> stringStream1 = Stream.of(null);
        //error
        System.out.println(stringStream1.count());

        Stream<String> stringStream2 = Stream.ofNullable(null);
        System.out.println(stringStream2.count());
        Stream<String> stringStream3 = Stream.ofNullable("AAAB");
        System.out.println(stringStream3.count());
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
        demoList.sort(new Comparator<ObjectDemo>() {
            @Override
            public int compare(ObjectDemo o1, ObjectDemo o2) {
                return o1.getStr().compareTo(o2.getStr());
            }
        });
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


    /**
     * 6.1
     *
     * @return
     */
//    public int serialArraySum() {
//        List<String> albums = new ArrayList();
//        return albums.stream()
//                .flatMap(Album::getTracks)
//                .mapToInt(Track::getLength)
//                .sum();
//
//    }

    //ParallelStream begin
    /**
     * 6.2
     *
     * @return
     */
//    public int parallelArraySum() {
//        List<String> albums = new ArrayList();
//        return albums.parallelStream()
////                .flatMap(Album::getTracks)
//                .mapToInt(Track::getLength)
//                .sum();
//    }


    /**
     * 6.3 使用蒙特卡洛模拟法并行化模拟投掷子事件
     *
     * @return Map<Integer, Double> 点数之和到他们的概率的映射
     */
//    public Map<Integer, Double> parallelDiceRolls() {
//
//        int N = 10;
//        double fraction = 1.0 / N;
//        return
//                //使用intStream的range方法创建大小为N的流
//                IntStream.range(0, N)
//                        //使用parallel方法使流的并行化操作
//                        .parallel()
//                        //twoDiceThrows函数模拟连续投掷两次骰子子事件，返回值为两次点数之和
//                        //使用mapToObj方法以便在流上使用该函数
//                        .mapToObj(twoDiceThrows())
//                        //得到需要合并的所有结果的流
//                        // groupingBy方法将点数一样的结果合并。
//                        .collect(groupingBy(side -> side
//                                //使用summingDouble方法完成这一步。
//                                , summingDouble(n -> fraction)));
//    }

    /**
     * 7.1 BinaryOperator 1-n规约流
     *
     * @param n
     * @return
     */
    private static long sequentialSum(long n) {
        return Stream.iterate(
                        //生成自然数无限流
                        1L, i -> i + 1)
                //限制到前n个数
                .limit(n)
                //对所有数字求和来归纳流
                .reduce(0L, Long::sum);
    }

    /**
     * 7.1.1 并行流，函数规约
     *
     * @param n
     * @return
     */
    private static long parallelSum(long n) {
        return Stream.iterate(
                        //生成自然数无限流
                        1L, i -> i + 1)
                //限制到前n个数
                .limit(n)
                //将流转换成并行流
                .parallel()
                //对所有数字求和来归纳流
                .reduce(0L, Long::sum);
    }
    //ParallelStream end
}
