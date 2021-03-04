package com.latte.limit;

import com.google.common.util.concurrent.RateLimiter;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author dongyl-work
 * @date 2021/3/4 下午12:37
 **/
public class LimitUtils {
    public static void main(String[] args) throws InterruptedException {
        RateLimiter limiter = RateLimiter.create(5,1, TimeUnit.MICROSECONDS);
        for (int i = 1; i < 5; i++) {
            System.out.println(limiter.acquire());
        }
        Thread.sleep(1000L);
        for (int i = 1; i < 5; i++) {
            System.out.println(limiter.acquire());
        }
    }

    private static void xx() throws InterruptedException {
        //每秒新增5个令牌桶，200ms 新增一个
        RateLimiter limiter = RateLimiter.create(2);
        System.out.println(limiter.acquire());
        Thread.sleep(2000L);
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
    }
}
