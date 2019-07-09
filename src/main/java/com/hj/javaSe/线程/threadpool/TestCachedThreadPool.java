package com.hj.javaSe.线程.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Author: hj
 * Date: 2019-07-06 17:47
 * Description: <描述>
 */
public class TestCachedThreadPool {

    /**
     *CachedThreadPool线程池
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        Future<?> submit = pool.submit(new ThreadPool1());
        pool.shutdown();
    }
}
