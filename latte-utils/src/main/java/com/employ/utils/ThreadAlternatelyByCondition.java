package com.employ.utils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程交替输出问题
 */
public class ThreadAlternatelyByCondition {
    public static void main(String[] args) {
        String thread1 = "1234567";
        String thread2 = "abcdefg";
        condition(thread1.toCharArray(),thread2.toCharArray());
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
}
