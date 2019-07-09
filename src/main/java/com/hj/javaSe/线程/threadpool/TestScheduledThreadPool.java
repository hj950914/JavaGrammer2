package com.hj.javaSe.线程.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Author: hj
 * Date: 2019-07-06 17:49
 * Description: <描述>
 */
public class TestScheduledThreadPool {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(10);
        pool.schedule(new ThreadPool1(),10, TimeUnit.SECONDS);
        pool.shutdown();
    }
}
