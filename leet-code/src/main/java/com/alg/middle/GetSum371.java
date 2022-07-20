package com.alg.middle;

public class GetSum371 {

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        System.out.println(a + b);
        System.out.println(getSum(a, b));
    }

    public static int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
