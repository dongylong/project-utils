package com.alg.middle;

import java.util.ArrayList;
import java.util.List;

public class Divide29 {

    public static void main(String[] args) {
        int dividend = 0;
        int divisor = 0;
        divide(dividend, divisor);
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        if (dividend == 0) {
            return 0;
        }
        boolean rev = false;
        if (dividend > 0) {
            dividend = -dividend;
            rev = !rev;
        }
        if(divisor >0){
            divisor = -divisor;
            rev = !rev;
        }
        List<Integer> candidates = new ArrayList<>();
        candidates.add(divisor);
        int index = 0;
        while (candidates.get(index) >= dividend - candidates.get(index)) {
            candidates.add(candidates.get(index) + candidates.get(index));
            ++index;
        }
        int ans = 0;
        for (int i = candidates.size() - 1; i >= 0; --i) {
            if (candidates.get(i) >= dividend) {
                ans += 1 << i;
                dividend -= candidates.get(i);
            }
        }
        return rev ? -ans : ans;
    }
}
