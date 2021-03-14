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
    private static Thread t1 = null;
    private static Thread t2 = null;

    static  Lock lock = new ReentrantLock();
    static Condition condition1 = lock.newCondition();
    static Condition condition2 = lock.newCondition();
    private static CountDownLatch latch = new CountDownLatch(1);
    public static void main(String[] args) {
        String thread1 = "1234567";
        String thread2 = "abcdefg";
        char[] td1 = thread1.toCharArray();
        char[] td2 = thread2.toCharArray();
        waitNotify(td1, td2);
//        park(td1,td2);
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


    public static void waitNotify(char[] td1, char[] td2) {
        final Object o = new Object();
        new Thread(() -> {
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

    public static void park(char[] td1, char[] td2) {
        t1 = new Thread(() -> {
            for (char c : td1) {
                System.out.print(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        }, "t1");

        t2 = new Thread(() -> {
            for (char c : td2) {
                System.out.print(c);
                LockSupport.unpark(t1);
                LockSupport.park();
            }
        }, "t2");
        t1.start();
        t2.start();

    }

}
