package com.latte.utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.nio.client.HttpAsyncClient;
import org.apache.http.nio.client.methods.HttpAsyncMethods;
import org.apache.http.nio.protocol.BasicAsyncResponseConsumer;
import org.apache.http.nio.protocol.HttpAsyncRequestProducer;
import org.slf4j.MDC;

import java.util.Map;
import java.util.concurrent.*;

public class ThreadUtils {

    final static ExecutorService executor = Executors.newFixedThreadPool(5);
    static HttpAsyncClient httpAsyncClient;

    public void completableFutureTest1() {
        CompletableFuture<String> future1 = new CompletableFuture<>();
        CompletableFuture<String> future2 = new CompletableFuture<>();
        CompletableFuture<String> future3 = new CompletableFuture<>();
        //不阻塞主线程
        CompletableFuture.allOf(future1, future2, future3)
                .thenApplyAsync((Void) -> {
                    //异步处理1，2，3结果
                    System.out.println("1");
                    return "";
                })
                .exceptionally(e -> {
                    //处理异常
                    System.out.println(e);
                    return "";
                });

    }

    public void completableFutureTest2() {
        CompletableFuture<String> future1 = new CompletableFuture<>();
        CompletableFuture<String> future2 = new CompletableFuture<>();
        future1.thenAcceptBothAsync(future2, (future1Result, future2Result) -> {
            //异步处理1，2结果
            System.out.println("1");
        })
                //处理异常
//                .exceptionally(e -> {
//                    return
//                }
//        )
        ;

    }

    public void completableFutureTest3() {
        CompletableFuture<String> future1 = new CompletableFuture<>();
        CompletableFuture<String> future2 = future1.thenApplyAsync((v) -> "result from service2");
        CompletableFuture<String> future3 = new CompletableFuture<>();
        future2.thenCombineAsync(future3, (f2Result, f3Result) -> {
            //异步处理1，2，3结果
            System.out.println("1");
            return "";
        })
                .exceptionally(e -> {
                    //处理异常
                    System.out.println(e);
                    return "";
                });

    }

    public void callBackDemo() {
        HttpAsyncRequestProducer producer = HttpAsyncMethods.create(new HttpGet());
        CompletableFuture asyncFuture = new CompletableFuture();
        BasicAsyncResponseConsumer consumer = new BasicAsyncResponseConsumer();
        FutureCallback callback = new FutureCallback<HttpResponse>() {
            @Override
            public void completed(HttpResponse response) {
                asyncFuture.complete(response);
            }

            @Override
            public void failed(Exception ex) {
                asyncFuture.completeExceptionally(ex);
            }

            @Override
            public void cancelled() {
                asyncFuture.cancel(true);
            }
        };
        httpAsyncClient.execute(producer, consumer, callback);
    }

    public void futureTaskDemo() {
        Future<String> future1 = null;
        Future<String> future2 = null;
        try {
            future1 = executor.submit(() -> futureTaskDemoService());
            future2 = executor.submit(() -> futureTaskDemoService());
            String resp1 = future1.get(300, TimeUnit.MICROSECONDS);
            String resp2 = future2.get(200, TimeUnit.MICROSECONDS);
        } catch (Exception e) {
            if (future1 != null) {
                future1.cancel(true);
            }
            if (future2 != null) {
                future2.cancel(true);
            }
            throw new RuntimeException(e);
        }
    }

    public String futureTaskDemoService() {

        return "";
    }

    public static void copyMDCProperty() {
        Map<String, String> mdcCopy = MDC.getCopyOfContextMap();
        try {
            MDC.setContextMap(mdcCopy);
        } catch (Exception e) {

        } finally {
            MDC.clear();
        }
    }
}
