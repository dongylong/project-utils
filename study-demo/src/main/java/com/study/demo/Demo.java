package com.study.demo;

import org.springframework.util.StringUtils;

/**
 *
 */
public class Demo {
    private int len;
    private int[] arr;

    public void push(int value) {
        arr[len] = value;
        len++;
    }

    public int pop() {
        if (len < 0) {
            throw new RuntimeException("无元素");
        }
        int cur = len - 1;
        int val = arr[cur];
        arr[cur] = 0;
        len--;
        return val;
    }

    public int minValue() {
        int minum = 0;
        for (int i = 0; i < len - 1; i++) {
            if (minum > arr[i]) {
                minum = arr[i];
            }
        }
        return minum;
    }


    public static void main(String[] args) {
        String s = "123";
        String[] s1 = s.split(" ");
    }

    public int queryLastWordLengthByCursor(String str){
        int endCur = str.length()-1;
        while (endCur>=0 && str.charAt(endCur) ==' '){
            endCur--;
        }
        if(endCur<0){
            return 0;
        }
        int startCur = endCur;
        while (startCur>=0 && str.charAt(startCur)!= ' '){
            startCur--;
        }
        return endCur -startCur;
    }
    public int lengthOfLastWordSplit1(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        if (end < 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }

    public int lengthOfLastWordSplit(String s) {
        try {
            String[] split = s.split(" ");
            return split[split.length - 1].length();
        } catch (Exception e) {
            return 0;
        }
    }

    public int lengthOfLastWordByCur(String str) {
        if(StringUtils.isEmpty(str)){
            return 0;
        }
        int count =0 ;
        int strLen = str.length() - 1;
        for (int i = strLen; i >=0; i--) {

        }
        return
    }
    public int lengthOfLastWord(String s) {
        if (s.length() == 0 || s == null) return 0;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count == 0) continue;
                break;
            }
            count++;
        }
        return count;
    }
}
