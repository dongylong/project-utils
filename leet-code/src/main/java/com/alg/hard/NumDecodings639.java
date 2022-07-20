package com.alg.hard;

public class NumDecodings639 {
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        System.out.println(numDecodings("1*"));
    }

    private static int numDecodings(String s) {
        int len = s.length();
        long a = 0;
        long b = 1;
        long c = 0;
        for (int i = 1; i <= len; ++i) {
            c = b * checkDigit(s.charAt(i - 1)) % MOD;
            if (i > 1) {
                c = (c + a * checkDigit(s.charAt(i - 2), s.charAt(i - 1))) % MOD;
            }
            a = b;
            b = c;
        }
        return (int) c;
    }

    public static int checkDigit(char ch) {
        if (ch == '0') {
            return 0;
        }
        return ch == '*' ? 9 : 1;
    }

    public static int checkDigit(char c0, char c1) {
        if (c0 == '*' && c1 == '*') {
            return 15;
        }
        if (c0 == '*') {
            return c1 <= '6' ? 2 : 1;
        }
        if (c1 == '*') {
            if (c0 == '1') {
                return 9;
            }

            if (c0 == '2') {
                return 6;
            }
            return 0;
        }
        return (c0 != '0' && (c0 - '0') * 10 + (c1 - '0') <= 26) ? 1 : 0;

    }

}
