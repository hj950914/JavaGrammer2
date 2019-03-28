package com.hj.javaSe.线程;

/**
 * Author: hj
 * Date: 2019-03-28 14:07
 * Description: <线程生命周期,sleep()休眠>
 */
public class ThreadTestThree implements Runnable{


    @Override
    public void run() {
        for (int i=1;i<=15;i++){
            System.out.println(Thread.currentThread().getName()+"执行第"+i+"次");
            try {
                //休眠,毫秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        ThreadTestThree threadTestThree=new ThreadTestThree();
        Thread thread=new Thread(threadTestThree);
        thread.start();
        Thread thread1=new Thread(threadTestThree);
        thread1.start();
    }
}
