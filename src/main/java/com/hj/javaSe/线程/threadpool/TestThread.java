package com.hj.javaSe.线程.threadpool;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Author: hj
 * Date: 2019-07-06 17:09
 * Description: 线程池使用
 */
public class TestThread {

    /**
     * 没有使用线程池
     */
    public static void main(String[] args) {
        ThreadPool1 threadPool1 = new ThreadPool1();
        Thread thread = new Thread(threadPool1);
        thread.start();
    }

}
