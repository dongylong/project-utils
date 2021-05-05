package com.alg.middle;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber137 {
    public SingleNumber137() {
    }

    public int singleNumberHash(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey();
            int occ = entry.getValue();
            if (occ == 1) {
                ans = num;
                break;
            }
        }
        return ans;
    }

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num : nums) {
                total +=((num>>i)&1);
            }
            if(total %3 !=0){
                ans|=(1<<i);
            }
        }
        return ans;
    }

    public int singleNumberBit(int[] nums) {
        int a = 0;
        int b = 0;
        for (int num : nums) {
            int aNext = (~a & b & num) | (a & ~b & ~num);
            int bNext = ~a & (b ^ num);
            a = aNext;
            b = bNext;
        }
        return b;
    }
}