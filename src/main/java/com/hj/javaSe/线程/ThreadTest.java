package com.hj.javaSe.线程;

import org.junit.jupiter.api.Test;


/**
 * Author: hj
 * Date: 2019-03-28 12:54
 * Description: <Thread类线程测试,继承Thread类>
 */
public class ThreadTest extends Thread {

    //重写Thread类里的run()方法
    @Override
    public void run() {
        System.out.println(getName() + "该线程正在执行！");
    }

    @Test
    void testOne() {
        //System.out.println("主线程1");
        ThreadTest threadTest = new ThreadTest();
        //启动线程
        threadTest.start();
        //线程只能启动一次,这里会抛异常
        //threadTest.start();
        //System.out.println("主线程2");
    }
}
