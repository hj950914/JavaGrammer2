package com.hj.javaSe.线程;

import org.junit.jupiter.api.Test;

/**
 * Author: hj
 * Date: 2019-03-28 14:24
 * Description: <线程生命周期,join()抢占资源>
 */
public class ThreadFour extends Thread {

    @Override
    public void run() {
        for (int i=1;i<=10;i++){
            System.out.println(getName()+"正在执行"+i+"次");
        }
    }

    @Test
    void testOne() {
        ThreadFour threadFour=new ThreadFour();
        threadFour.start();
        try {
            //抢占资源,里面的参数表示抢占资源执行1毫秒后,让给其它线程执行
            threadFour.join(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //和抢占资源的线程作对比
        for (int i=1;i<=10;i++){
            System.out.println("主线程运行第"+i+"次");
        }
        System.out.println("主线程运行结束");
    }
}
