package com.alg.middle;

/**
 * 压缩字符串
 * 给定一组字符，使用原地算法将其压缩。
 * 压缩后的长度必须始终小于或等于原数组长度。
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 * 在完成原地修改输入数组后，返回数组的新长度。
 *
 * 进阶：
 * 你能否仅使用O(1) 空间解决问题？
 *
 * 输入：
 * ["a","a","b","b","c","c","c"]
 *
 * 输出：
 * 返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
 *
 * 说明：
 * "aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
 *
 * 输入：
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 *
 * 输出：
 * 返回 4 ，输入数组的前4个字符应该是：["a","b","1","2"]。
 *
 * 解释：
 * 由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。
 * 注意每个数字在数组中都有它自己的位置。
 *
 * @author dongyl-work
 * @date 2021/2/8 下午10:23
 **/
public class CompressStrAlg {
    /**
     * 时间复杂度：O(N)O(N)，其中 NN 是 chars 的长度。
     * 空间复杂度：O(1)O(1)，三个指针的占用空间。
     * @param chars
     * @return
     */
    public static int compress(char[] chars) {
        //标注一段连续字符的起始位置;
        int anchor = 0;
        //write为写入指针
        int write = 0;
        int len = chars.length;
        for (int read = 0; read < len; read++) {
            // 当达到数组最后位置或连续字符的最后位置
            if (read + 1 == len || chars[read + 1] != chars[read]) {
                // 写入字符
                chars[write++] = chars[anchor];
                // 写入长度
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }

    public static void main(String[] args) {
        //数组必须连续
        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b','c'};
        int index = compress(chars);
        for (int i = 0; i < index; i++) {
            System.out.println(chars[i]);
        }
    }
}
