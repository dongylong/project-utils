package com.alg.easy;

/**
 * 检查数组是否经排序和轮转得到
 *
 * @author dongyl-work
 * @date 2021/2/9 上午10:20
 **/
public class CheckAlg {
    public boolean check(int[] nums) {
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > nums[(i + 1) % len]) {
                count++;
            }
        }
        return count <= 1;
    }
}
