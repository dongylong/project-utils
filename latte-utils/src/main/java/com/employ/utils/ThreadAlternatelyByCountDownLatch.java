package com.employ.utils;

import java.util.concurrent.CountDownLatch;

/**
 * 线程交替输出问题
 */
public class ThreadAlternatelyByCountDownLatch {
    private static CountDownLatch latch = new CountDownLatch(1);
    public static void main(String[] args) {
        String thread1 = "1234567";
        String thread2 = "abcdefg";
    }

    public static void countDownLatch(char[] td1, char[] td2) {
        final Object o = new Object();

        new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o) {
                for (char c : td1) {
                    System.out.print(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "t1").start();
        new Thread(() -> {
            synchronized (o) {
                for (char c : td2) {
                    System.out.print(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "t2").start();
    }
}
