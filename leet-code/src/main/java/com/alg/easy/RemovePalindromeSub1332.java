package com.alg.easy;

public class RemovePalindromeSub1332 {
    public static void main(String[] args) {
        String s = "aba";
        int i = removePalindromeSub(s);
        System.out.println(i);
    }
    public static int removePalindromeSub(String s) {
        int length = s.length();
        for (int i = 0; i < length/2; i++) {
            if(s.charAt(i) !=s.charAt(length-1-i)){
                return 2;
            }
        }
        return 1;
    }
}
