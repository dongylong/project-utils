package com.latte.hystrix;

import com.netflix.hystrix.*;

/**
 * @author dongyl-work
 * @date 2021/3/5 下午6:23
 **/
public class GetStockServiceCommand extends HystrixCommand<String> {

    private StockService stockService;

    public GetStockServiceCommand(StockService stockService) {
        super(setter());
        this.stockService = stockService;
    }

    protected GetStockServiceCommand(HystrixCommandGroupKey group) {
        super(group);
    }

    protected GetStockServiceCommand(HystrixCommandGroupKey group, HystrixThreadPoolKey threadPool) {
        super(group, threadPool);
    }

    protected GetStockServiceCommand(HystrixCommandGroupKey group, int executionIsolationThreadTimeoutInMilliseconds) {
        super(group, executionIsolationThreadTimeoutInMilliseconds);
    }

    protected GetStockServiceCommand(HystrixCommandGroupKey group, HystrixThreadPoolKey threadPool, int executionIsolationThreadTimeoutInMilliseconds) {
        super(group, threadPool, executionIsolationThreadTimeoutInMilliseconds);
    }

    protected GetStockServiceCommand(Setter setter) {
        super(setter);
    }

    private static Setter setter() {
        //服务分组
        HystrixCommandGroupKey groupKey = HystrixCommandGroupKey.Factory.asKey("ShortUrlGroupKey");
        //配置全局唯一服务标识名称
        HystrixCommandKey commandKey = HystrixCommandKey.Factory.asKey("shortUrlCommandKey");
        //配置全局唯一标识线程池名称，相同线程池名称的线程池是同一个。不配置默认分组名，线程池名字前缀
        HystrixThreadPoolKey threadPoolKey =
                HystrixThreadPoolKey.Factory.asKey("shortUrl-pool");
        //线程池配置参数
        HystrixThreadPoolProperties.Setter threadPoolProperties =
                HystrixThreadPoolProperties.Setter()
                        //配置核心线程池大小和线程池最大大小，默认10
                        .withCoreSize(10)
                        //线程池中空闲线程生存时间
                        .withKeepAliveTimeMinutes(5)
                        .withMaxQueueSize(Integer.MAX_VALUE)
                        .withQueueSizeRejectionThreshold(10000);

        //命令属性配置
        HystrixCommandProperties.Setter commandProperties =
                HystrixCommandProperties.Setter()
                        //设置隔离策略，默认线程隔离
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)
                        //是否启用降级处理。超时/异常是调用getFallback方法降级。默认true
                        .withFallbackEnabled(true)
                        //默认10。
                        // fallback方法的信号量配置，配置getFallback方法并发请求的信号量。
                        // 若请求超过并发信号量限制，则不再尝试调用getFallback方法。而是快速失败。
                        .withExecutionIsolationSemaphoreMaxConcurrentRequests(15)
                        //默认false
                        //当隔离策略为THREAD时，执行线程超时，是否进行中中断处理。
                        .withExecutionIsolationThreadInterruptOnFutureCancel(true)
                        //是否启用执行超时机制
                        //默认true
                        .withExecutionTimeoutEnabled(true)
                        //执行最多等待ThreadPool时间 默认1000
                        //执行线程执行中断处理:命令是线程隔离，withExecutionIsolationThreadInterruptOnTimeout = true
                        //命令是信号量隔离，则进行终止操作(信号量隔离与主线程在同一线程中执行)
                        .withExecutionTimeoutInMilliseconds(3000)
                        //
                        //默认true
                        .withExecutionIsolationThreadInterruptOnTimeout(true)
                        //开启熔断模式
                        .withCircuitBreakerEnabled(true)
                        //出现错误的比率超过30%就开启熔断
                        .withCircuitBreakerErrorThresholdPercentage(30)
                        //至少有10个请求才进行errorThresholdPercentage错误百分比计算
                        .withCircuitBreakerRequestVolumeThreshold(10)
                        //半开试探休眠时间，这里设置为3秒
                        .withCircuitBreakerSleepWindowInMilliseconds(3000);
        return HystrixCommand.Setter
                .withGroupKey(groupKey)
                .andCommandKey(commandKey)
                .andThreadPoolKey(threadPoolKey)
                .andThreadPoolPropertiesDefaults(threadPoolProperties)
                .andCommandPropertiesDefaults(commandProperties);
    }

    @Override
    protected String run() throws Exception {
        return stockService.getStock();
    }

    /**
     * 受withExecutionIsolationSemaphoreMaxConcurrentRequests 控制，若失败率非常高，则重新配置该参数。
     * 若最大并发超过该配置，则不执行getFallback，而是快速失败。
     * todo
     * @return
     */
    @Override
    protected String getFallback() {
        //降级方法
        return "有货";
    }
}
