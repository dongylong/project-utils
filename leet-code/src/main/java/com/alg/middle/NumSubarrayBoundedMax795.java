package com.alg.middle;

public class NumSubarrayBoundedMax795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int res = 0;
        int last2 = -1;
        int last1 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                last1 = i;
            } else if (nums[i] > right) {
                last2 = i;
                last1 = -1;
            }
            if (last1 != -1) {
                res += last1 - last2;
            }
        }
        return res;
    }

    public int numSubarrayBoundedMaxCount(int[] nums, int left, int right) {
        return count(nums, right) - count(nums, left - 1);
    }

    public int count(int[] nums, int lower) {
        int res = 0, cur = 0;
        for (int x :
                nums) {
            cur = x <= lower ? cur + 1 : 0;
            res += cur;
        }
        return res;
    }
}
