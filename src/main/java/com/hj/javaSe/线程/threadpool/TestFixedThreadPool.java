package com.hj.javaSe.线程.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: hj
 * Date: 2019-07-06 17:27
 * Description: <描述>
 */
public class TestFixedThreadPool {

    /**
     * newFixedThreadPool线程池
     *
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        pool.execute(new ThreadPool1());
        pool.shutdown();
    }
}
