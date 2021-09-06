package com.employ.utils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程交替输出问题
 */
public class ThreadAlternately {
    private static CountDownLatch latch = new CountDownLatch(1);
    public static void main(String[] args) {
        String thread1 = "1234567";
        String thread2 = "abcdefg";
//        park(thread1,thread2);
//        executeNotifyWait(thread1,thread2);
        condition(thread1.toCharArray(),thread2.toCharArray());
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

    // -----------condition begin todo -----------

    static  Lock lock = new ReentrantLock();
    static Condition condition1 = lock.newCondition();
    static Condition condition2 = lock.newCondition();
    public static void condition(char[] td1, char[] td2) {
        new Thread(() -> {
            try {
                for (char c : td1) {
                    System.out.print(c);
                    condition2.signal();
                    condition1.await();
                }
                condition2.signal();
            }catch (Exception e){

            }finally {
                lock.unlock();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                for (char c : td2) {
                    System.out.print(c);
                    condition1.signal();
                    condition2.await();
                }
                condition1.signal();
            }catch (Exception e){

            }finally {
                lock.unlock();
            }
        }, "t2").start();
    }

    // -----------condition end -----------
    // -----------wait notify begin -----------
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

    // -----------wait notify end -----------
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
