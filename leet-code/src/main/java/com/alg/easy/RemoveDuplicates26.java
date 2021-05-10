package com.alg.easy;

public class RemoveDuplicates26 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = removeDuplicates(nums);
        print(nums,len);
    }

    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int fast = 1;
        int slow = 1;
        while (fast < length) {
            if (nums[fast] != nums[fast-1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    public static void print(int[] nums,int len) {
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}