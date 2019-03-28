package com.hj.javaSe.线程.hashMap和currentHashMap;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: hj
 * Date: 2019-03-28 17:07
 * Description: <多线程操作HashMap>
 */
public class HashMapTest {

    /*
     *  案例介绍:
     *   多个线程操作同一个HashMap(线程不安全),会出现数据错误。
     * */

    //k:学号
    //v:名字
    Map<String, String> mapStu = new HashMap<>();


    //线程1向map中存入数据
    public  Thread hashMapSave1() {
        Thread thread1 = new Thread (() -> {
            mapStu.put("001", "老李");
            System.out.println("线程1执行完毕");
        });
        return thread1;
    }

    //线程2向map中存入数据
    public Thread hashMapSave2() {
        Thread thread2 = new Thread(() -> {
            mapStu.put("002", "老黄");
            System.out.println("线程2执行完毕");
        });
        return thread2;
    }

    //线程2向map中存入数据
    public Thread hashMapSave3() {
        Thread thread3 = new Thread(() -> {
            mapStu.put("003", "老周");
            System.out.println("线程3执行完毕");
        });
        return thread3;
    }


    //测试方法
    @Test
    void test() {
        HashMapTest hashMapTest = new HashMapTest();
        Thread thread1=hashMapTest.hashMapSave1();
        thread1.start();
        Thread thread2=hashMapTest.hashMapSave2();
        thread2.start();
        Thread thread3=hashMapTest.hashMapSave3();
        thread3.start();

        //在集合结果中,可能会出现存入的数据和集合最终结果不一致
        System.out.println(mapStu);
    }
}
