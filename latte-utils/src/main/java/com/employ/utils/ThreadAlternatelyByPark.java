package com.employ.utils;

import java.util.concurrent.locks.LockSupport;

/**
 * 线程交替输出问题
 */
public class ThreadAlternatelyByPark {
    public static void main(String[] args) {
        String thread1 = "1234567";
        String thread2 = "abcdefg";
        park(thread1,thread2);
    }
    // -----------park begin -----------
    private static Thread t1 = null;
    private static Thread t2 = null;
    public static void park(String str, String num) {
        t1 = new Thread(() -> {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                System.out.print(c);
                LockSupport.park();
                LockSupport.unpark(t2);
            }
        }, "t1");
        t2 = new Thread(() -> {
            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                System.out.print(c);
                LockSupport.unpark(t1);
                LockSupport.park();
            }
        }, "t2");
        t1.start();
        t2.start();
    }
    // -----------park end -----------
}
