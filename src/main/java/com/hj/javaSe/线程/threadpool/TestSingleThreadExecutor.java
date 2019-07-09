package com.hj.javaSe.线程.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Author: hj
 * Date: 2019-07-06 17:30
 * Description: <描述>
 */
public class TestSingleThreadExecutor {

    /**
     * SingleThreadExecutor线程池
     *
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        //pool.execute(new ThreadPool1());
        //pool.shutdown();

        Future<?> submit = pool.submit(new ThreadPool1());
        pool.shutdown();
        try {
            System.out.println("返回值:"+submit.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
