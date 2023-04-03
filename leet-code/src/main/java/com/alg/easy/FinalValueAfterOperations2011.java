package com.alg.easy;

public class FinalValueAfterOperations2011 {
    public static void main(String[] args) {

        String[] operations = new String[]{"--X","X++","X++"};
        finalValueAfterOperations(operations);
    }

    private static int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String opt :operations){
            char c = opt.charAt(1);
            if(c =='+'){
                x++;
            }else{
                x--;
            }
        }
        return x;
    }
}
