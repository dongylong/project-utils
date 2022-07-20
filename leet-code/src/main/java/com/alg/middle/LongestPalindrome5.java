package com.alg.middle;

public class LongestPalindrome5 {
    public String longestPalindromeDP(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        for (int sCursor = 2; sCursor <= len; sCursor++) {
            for (int leftLimit = 0; leftLimit < len; leftLimit++) {
                int rightLimit = sCursor + leftLimit - 1;
                if (rightLimit >= len) {
                    break;
                }
                if (chars[leftLimit] != chars[rightLimit]) {
                    dp[leftLimit][rightLimit] = false;
                } else {
                    if (rightLimit - leftLimit < 3) {
                        dp[leftLimit][rightLimit] = true;
                    } else {
                        dp[leftLimit][rightLimit] = dp[leftLimit + 1][rightLimit - 1];
                    }
                }
                if (dp[leftLimit][rightLimit] && rightLimit - leftLimit + 1 > maxLen) {
                    maxLen = rightLimit - leftLimit + 1;
                    begin = leftLimit;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
