package com.latte.utils;

/**
 * @author dongyl-work
 * @date 2021/3/4 下午12:39
 **/
public class CharacterUtils {
    public static final String PATH_DELIMITER = "/";
    public static final String HYPHEN_DELIMITER = "-";
    public static final String DOT_DELIMITER = ".";
    public static final String QUESTION_MARK_DELIMITER = "?";
    public static final String EQUAL_SIGN_DELIMITER = "=";
    public static final String SPACE_DELIMITER = " ";
    public static final String COLON_DELIMITER = ":";
    public static final String AMPERSAND = "&";
    public static final String VERTICAL = "|";
    public static final String UNDER_LINE = "_";


    /**
     * 判定输入的是否是汉字
     * @param c 被校验的字符
     * @return true代表是汉字
     */
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }
}
