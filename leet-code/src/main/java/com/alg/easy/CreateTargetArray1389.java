package com.alg.easy;

/**
 * 1389. 按既定顺序创建目标数组
 */
public class CreateTargetArray1389 {

    public static void main(String[] args) {
//        int[] nums = new int[]{0, 1, 2, 3, 4};
//        int[] index = new int[]{0, 1, 2, 2, 1};
        //输出：[0,4,1,3,2]
        int[] nums = new int[]{1, 2, 3, 4, 0};
        int[] index = new int[]{0, 1, 2, 3, 0};
        //输出：[0,1,2,3,4]
        int[] ans = createTargetArray(nums, index);
        System.out.println(ans);
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        int indexLength = index.length;
        int[] ans = new int[indexLength];
        for (int i = 0; i < indexLength; i++) {
            for (int j = indexLength - 1; j > index[i]; j--) {
                ans[j] = ans[j - 1];
            }
            ans[index[i]] = nums[i];
        }
        return ans;
    }

}
