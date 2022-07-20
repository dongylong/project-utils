package com.alg.easy;

/**
 * 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
 * 翻转后单词间应当仅用一个空格分隔。
 * 翻转后的字符串中不应包含额外的空格。
 * 输入：s = "  Bob    Loves  Alice   "
 * 输出："Alice Loves Bob"
 */
public class ReverseWordsInAString151 {

    public static void main(String[] args) {
//        String s = "the sky is blue";
        String s = "  Bob    Loves  Alice   ";
        StringBuilder s1 = trimSpace(s);
        System.out.println("s1...." + s1 + "....s1");
        StringBuilder s2 = reverseStr(s1);
        System.out.println("s2...." + s2 + "....s2");
        String s3 = reverseWord(s2);
        System.out.println("s3...." + s3 + "....s3");
    }

    private static String reverseWord(StringBuilder s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length() - 1;
        int cursor = 0;
        int current = 0;
        for (int i = 1; i <= len; i++) {
            if (s.charAt(i) == ' ' || i == len) {
                cursor = i == len ? i : i - 1;
                //转换
                reverseWord(s, current, cursor);
                current = i + 1;
            } else {
                cursor++;
            }
        }
        return s.toString();
    }

    public static void reverseWord(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }

    }

    public static StringBuilder trimSpace(String s) {
        if (s == null || s == "") {
            return new StringBuilder();
        }
        int length = s.length();
        int left = 0;
        int right = length - 1;
        while (true) {
            if (s.charAt(left) == ' ') {
                left++;
            } else {
                break;
            }
        }
        while (true) {
            if (s.charAt(right) == ' ') {
                right--;
            } else {
                break;
            }
        }
        boolean spaceFlag = false;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = left; i <= right; i++) {
            if (s.charAt(i) == ' ') {
                if (spaceFlag) {
                    continue;
                }
                spaceFlag = true;
            } else {
                spaceFlag = false;
            }
            stringBuilder.append(s.charAt(i));

        }
        return stringBuilder;
    }

    public static StringBuilder reverseStr(StringBuilder s) {
        if (s == null || s.length() == 0) {
            return new StringBuilder();
        }
        int length = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = length; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb;
    }
}
