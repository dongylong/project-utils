package com.employ.utils;

/**
 * 线程交替输出问题
 */
public class ThreadAlternatelyByWaitNotify {
    public static void main(String[] args) {
        String thread1 = "1234567";
        String thread2 = "abcdefg";
        executeNotifyWait(thread1,thread2);
    }
    public static void executeNotifyWait(String str, String num) {
        final Object o = new Object();
        executeNotifyWait(str, "t1", o);
        executeNotifyWait(num, "t2", o);
    }

    public static void executeNotifyWait(String str, String threadName, final Object o) {
        new Thread(() -> {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                System.out.print(c);
                synchronized (o) {
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, threadName).start();
    }
}
