package com.study.demo.bytejump;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Prog10 {
    public static void main(String[] args) {
        double high;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入小球下落的高度：");
        high = input.nextDouble();
        input.close();
        jump(high);

    }

    private static void jump(double high) {
        int n = 1;
        double count = 0;
        while (n<11) {
            count += high;
            high /= 2;
            //格式化输出
            System.out.printf("%-22s","第"+n+"次落地共经过："+count);
            System.out.println("第"+n+"反弹的高度为："+high);
            n++;
            ConcurrentHashMap<Long,Long> xx = new ConcurrentHashMap<>();
        }
    }

}
