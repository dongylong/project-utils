package com.alg.middle;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class NthUglyNumber264 {
    public int nthUglyNumberStack(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        seen.add(1L);
        heap.offer(1L);
        int unly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            unly = (int)curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return unly;
    }

    public int nthUglyNumberDP(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 0; i <= n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            } else if (dp[i] == num2) {
                p3++;
            } else if (dp[i] == num2) {
                p5++;
            }
        }
        return dp[n];
    }
}