package com.alg.middle;

public class CombinationSum377 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int target = 4;
        int i = combinationSum4(nums, target);
        System.out.println(i);
    }

    /**
     * 一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。
     * 请从 nums 中找出并返回总和为 target 的元素组合的个数。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        for (int num : dp) {
            System.out.println(num);
        }
        return dp[target];
    }
}
