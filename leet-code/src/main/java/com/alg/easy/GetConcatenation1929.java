package com.alg.easy;

public class GetConcatenation1929 {
    public static void main(String[] args) {
        int[] nums =  new int[]{1,3,2,1};
        int[] concatenation = getConcatenation(nums);
        System.out.println(concatenation);
    }
    public static int[] getConcatenation(int[] nums) {
        int length = nums.length;
        int[] resp = new int[2* length];
        for(int i = 0 ;i <length;i++){
            resp[i]=nums[i];
            resp[i+length]=nums[i];
        }
        return resp;
    }
}
