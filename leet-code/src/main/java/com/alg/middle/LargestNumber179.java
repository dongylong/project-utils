package com.alg.middle;

import java.util.Arrays;

public class LargestNumber179 {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0] + "";
        }
        Integer[] numsArr = new Integer[len];
        for (int i = 0; i < len; i++) {
            numsArr[i] = nums[i];
        }
        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });
        if (numsArr[0] == 0) {
            return 0 + "";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);

        }
        return ret.toString();
    }
}
