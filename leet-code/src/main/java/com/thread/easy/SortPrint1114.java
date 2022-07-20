package com.thread.easy;

import java.util.concurrent.atomic.AtomicInteger;

public class SortPrint1114 {
    private AtomicInteger atomicInteger1 = new AtomicInteger(0);
    private AtomicInteger atomicInteger2 = new AtomicInteger(0);

    public void first(Runnable printFirst) throws InterruptedException {
        atomicInteger1.getAndIncrement();
        printFirst.run();
    }


}
