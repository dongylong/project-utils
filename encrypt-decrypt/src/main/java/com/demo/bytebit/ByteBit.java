package com.demo.bytebit;

/**
 * ByteBit
 *
 * @Description:
 */
public class ByteBit {
    public static void main(String[] args) {
        String a = "a";
        byte[] bytes = a.getBytes();
        for (byte aByte : bytes) {
            int c = aByte;
            System.out.println(c);
            // byte 字节，对应的bit是多少
            String s = Integer.toBinaryString(c);
            System.out.println(s);
        }
    }
}