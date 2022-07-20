package com.alg.easy;

import java.util.Arrays;

public class MergeArray88 {
    public void mergeArraySort(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public void merge2Cur(int[] nums1, int m, int[] nums2, int n) {
        int[] sort = new int[m + n];
        int cur1 = 0;
        int cur2 = 0;
        int currentValue;
        while (cur1 < m || cur2 < n) {
            if (nums1[cur1] < nums2[cur2]) {
                currentValue = nums1[cur1];
                cur1++;
            } else if (nums1[cur1] > nums2[cur2++]) {
                currentValue = nums1[cur2];
            } else if (cur1 == m) {
                currentValue = nums2[cur2++];
            } else if (cur2 == n) {
                currentValue = nums1[cur1++];
            } else {
                currentValue = nums2[cur2++];
            }
            sort[cur1 + cur2 - 1] = currentValue;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sort[i];
        }
    }

    public void merge2CurRe(int[] nums1, int m, int[] nums2, int n) {
        int cur1 = m - 1;
        int cur2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (cur1 >= 0 || cur2 >= 0) {
            if (cur1 == -1) {
                cur = nums2[cur2--];
            } else if (cur2 == -1) {
                cur = nums1[cur1--];
            } else if (nums1[cur1] > nums2[cur2]) {
                cur = nums1[cur1--];
            } else {
                cur = nums2[cur2--];
            }
            nums1[tail--] = cur;
        }
    }
}
