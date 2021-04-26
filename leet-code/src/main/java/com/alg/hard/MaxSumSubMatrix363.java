package com.alg.hard;

import java.util.TreeSet;

/**
 * @author dongyl-work
 * @date 2021/4/22 下午10:09
 **/
public class MaxSumSubMatrix363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int ans = Integer.MIN_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; ++i) {
            int[] sum = new int[n];
            for (int j = i; j < m; ++j) {
                for (int c = 0; c < n; ++c) {
                    sum[c] +=matrix[j][c];
                }
                TreeSet<Integer> sumSet = new TreeSet<>();
                sumSet.add(0);
                int s = 0;
                for (int v: sum) {
                    s +=v;
                    Integer ceil = sumSet.ceiling(s-k);
                    if(ceil!=null){
                        ans = Math.max(ans,s-ceil);
                    }
                    sumSet.add(s);
                }
            }
        }
        return ans;
    }
}
