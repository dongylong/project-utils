package com.alg.easy;

/**
 * 基于排列构建数组
 */
public class BuildArray1920 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 1, 5, 3, 4};
        int[] ints = buildArray(nums);
        System.out.println(ints);
    }

    public static int[] buildArray(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
