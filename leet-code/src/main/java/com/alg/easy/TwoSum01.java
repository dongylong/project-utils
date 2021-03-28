package com.alg.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum01 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int tar = 6;
        int[] ret = twoSum(nums, tar);
        for (int i = 0; i < ret.length; i++) {
            System.out.println(ret[i]);

        }
    }


    public static int[] twoSumMap(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < len - 1; i++) {
            if (result.containsKey(target - nums[i])) {
                return new int[]{result.get(target - nums[i]),i};
            }
            result.put(nums[i], i);
        }
        return new int[0];
    }

    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
