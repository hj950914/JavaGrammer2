package com.hj.javaSe.线程;


/**
 * Author: hj
 * Date: 2019-03-28 14:50
 * Description: <线程的优先级(1-10级)>
 */
public class ThreadFive extends Thread {


    public ThreadFive(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(getName() + "正在运行第" + i+"次");
        }
    }

    public static void main(String[] args) {
        //获取主线程的优先级,默认优先级5
        System.out.println("主线程的优先级为:" + Thread.currentThread().getPriority());
        //
        ThreadFive threadFive = new ThreadFive("线程1");
        //设置自定义线程的优先级
        threadFive.setPriority(10);
        //方式2threadFive.setPriority(Thread.MAX_PRIORITY);
        threadFive.start();
        System.out.println(threadFive.getName()+"的优先级为:"+threadFive.getPriority());
    }


}
