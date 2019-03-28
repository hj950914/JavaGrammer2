package com.hj.javaSe.线程;

import org.junit.jupiter.api.Test;

/**
 * Author: hj
 * Date: 2019-03-28 13:10
 * Description: <Thread类测试>
 */
public class ThreadTestTwo extends Thread {

    public ThreadTestTwo(String threadName) {
        //访问Thread类的构造方法传入线程名称
        super(threadName);
    }

    //实现run方法
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(getName() + "正在运行" + i);
        }
    }

    public static void main(String srgs[]) {
        ThreadTestTwo threadTestTwo1 = new ThreadTestTwo("线程1");
        ThreadTestTwo threadTestTwo2 = new ThreadTestTwo("线程2");
        threadTestTwo1.start();
        threadTestTwo2.start();
    }
}
