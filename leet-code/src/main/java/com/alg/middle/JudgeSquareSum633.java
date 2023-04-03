package com.alg.middle;

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 */
public class JudgeSquareSum633 {
    public static void main(String[] args) {
        System.out.println(judgeSquareSumSqurtjudgeSqutSum(100));
    }

    public static boolean judgeSquareSum(int c) {
        for (int i = 2; i * i < c; i++) {
            if (c % i != 0) {
                continue;
            }
            int exp = 0;
            while (c % i == 0) {
                c /= i;
                exp++;
            }
            if (i % 4 == 3 && exp % 2 != 0) {
                return false;
            }
        }
        return c % 4 != 3;

    }

    public static boolean judgeSquareSumSqurtjudgeSqutSum(int c) {
        long a = 0;
        long b = (long) Math.sqrt(c);
        long sum = 0;
        while (a <= b) {
            sum = a * a + b * b;
            if (sum == c) {
//                System.out.println("a:" + a + ",b:" + b + " = " + c);
                return true;
            } else if (sum > c) {
                b--;
            } else {
                a++;
            }

        }
        return false;
    }
}