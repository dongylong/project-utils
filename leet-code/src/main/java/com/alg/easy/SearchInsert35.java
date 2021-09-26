package com.alg.easy;

public class SearchInsert35 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int insertValue = 10;
        System.out.println(searchInsert(nums, insertValue));
    }

    private static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int pos = len;
        while (left <= right) {
            //mid=(right - left) >> 1 相当于 mid=(right - left)/2
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                pos = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return pos;
    }
}
