package com.latte.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

/**
 * @author dongyuanlong
 */
public class StreamUtils {


    public static void main(String[] args) {
//        streamNullDemo();
        listNullDemo();
    }


    public static void jdk11_feature() {

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
//                .flatMap(Album::getTracks)
//                .mapToInt(Track::getLength)
//                .sum();
//    }


    /**
     * 6.3 使用蒙特卡洛模拟法并行化模拟投掷子事件
     *
     * @return Map<Integer, Double> 点数之和到他们的概率的映射
     */
    public Map<Object, Double> parallelDiceRolls() {

        int N = 10;
        double fraction = 1.0 / N;
        return
                //使用intStream的range方法创建大小为N的流
                IntStream.range(0, N)
                        //使用parallel方法使流的并行化操作
                        .parallel()
                        //twoDiceThrows函数模拟连续投掷两次骰子子事件，返回值为两次点数之和
                        //使用mapToObj方法以便在流上使用该函数
                        .mapToObj(twoDiceThrows())
                        //得到需要合并的所有结果的流
                        // groupingBy方法将点数一样的结果合并。
                        .collect(groupingBy(side -> side
                                //使用summingDouble方法完成这一步。
                                , summingDouble(n -> fraction)));
    }

    private IntFunction<Double> twoDiceThrows() {
        return null;
    }

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
