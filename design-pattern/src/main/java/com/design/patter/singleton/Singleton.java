package com.design.patter.singleton;

public class Singleton {
    private volatile static Singleton singletonDoubleCheckLockPattern;
    private Singleton() {
    }

    public static Singleton getInstanceDoubleCheckLockPattern() {
        if (singletonDoubleCheckLockPattern == null) {
            synchronized (Singleton.class) {
                if (singletonDoubleCheckLockPattern == null) {
                    singletonDoubleCheckLockPattern = new Singleton();
                }
            }
        }
        return singletonDoubleCheckLockPattern;
    }
}
