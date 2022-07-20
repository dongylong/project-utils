package com.latte.utils;

import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;

import javax.annotation.Resource;

public class RedisUtils {

    @Resource
    RedissonClient redissonClient;

    public void getRReadLock(String key){
        RReadWriteLock lock = redissonClient.getReadWriteLock(key);
        RLock rLock = lock.readLock();
        //
        System.out.println("r-lock");
        rLock.unlock();
        System.out.println("r-end");
    }
    public void getRWriteLock(String key){
        RReadWriteLock lock = redissonClient.getReadWriteLock(key);
        RLock rLock = lock.writeLock();
        //
        System.out.println("w-lock");
        rLock.unlock();
        System.out.println("w-end");
    }

}
