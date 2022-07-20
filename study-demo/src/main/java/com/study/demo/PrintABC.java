package com.study.demo;

public class PrintABC {
    public static void main(String[] args) {

    }


    public static void printByJoin() {
        Thread thread1 = new Thread(() -> {
            System.out.println("a");
        });
        Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("b");
        });
        Thread thread3 = new Thread(() -> {
            try {
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("c");
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
