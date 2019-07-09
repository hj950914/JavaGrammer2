package com.hj.javaSe.线程.threadpool;

/**
 * Author: hj
 * Date: 2019-07-04 18:13
 * Description:
 */
public class ThreadPool1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "执行第" + i + "次");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
