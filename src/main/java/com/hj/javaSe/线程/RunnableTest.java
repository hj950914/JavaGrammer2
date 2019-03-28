package com.hj.javaSe.线程;

import org.junit.jupiter.api.Test;

/**
 * Author: hj
 * Date: 2019-03-28 13:34
 * Description: <Runnable接口测试>
 */
public class RunnableTest implements Runnable {

    int i=1;

    //实现接口里面的方法
    @Override
    public void run() {
        //将i定义到成员变量里,可以实现多个线程共享同一个run方法
        for (; i <= 10; i++) {
            //Thread.currentThread()获取当前线程
            System.out.println(Thread.currentThread().getName() + "正在运行" + i
            );
        }
    }

    @Test
    void testOne() {
        RunnableTest runnableTest = new RunnableTest();
        //启动线程，需要借用Thread来启动线程
        Thread thread = new Thread(runnableTest);
        thread.start();
        Thread thread1=new Thread(runnableTest);
        thread1.start();

    }
}
