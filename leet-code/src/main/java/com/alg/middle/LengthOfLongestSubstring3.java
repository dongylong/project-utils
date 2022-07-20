package com.alg.middle;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring3 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(s + "..." + lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int total = 0;
        int length = s.length();
        Set<Character> charSet = new HashSet<>(length);
        int rk = -1;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                charSet.remove(s.charAt(i - 1));
            }
            while (rk + 1 < length && !charSet.contains(s.charAt(rk + 1))) {
                charSet.add(s.charAt(rk + 1));
                ++rk;
            }
            System.out.println(charSet);
            total = Math.max(total,rk-i+1);
        }
        return total;
    }
}
