package com.hj.javaSe.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

/**
 * Author: hj
 * Date: 2019-03-26 18:04
 * Description: <方法反射的操作>
 */
public class ReflectTest2 {

    /*
     * 反射获取方法
     * */
    @Test
    void testOne() {
        /*
         * 要获取pring()方法
         * 1:要获取一个方法就是获取类的信息,获取类的信息首先要获取类的类类型
         * */
        ReflectTest2 reflectTest2 = new ReflectTest2();
        Class c = reflectTest2.getClass();
        //2:获取方法,由名称和参数列表来决定
        try {
            //获取方法print(int,int)
            Method m = c.getMethod("print", int.class, int.class);
            //方法的反射操作,用m的对象进行方法调用
            //相当于invoke(类的实例,实参... )
            //reflectTest2.print(10,20)
            m.invoke(reflectTest2, 10, 20);

            //获取方法print(String,String)
            Method m1 = c.getMethod("print", String.class, String.class);
            //reflectTest2.print("aa","bb")
            m1.invoke(reflectTest2, "aa", "bb");

            //获取方法print()
            //Method m2=c.getMethod("print",new Class[]{});
            Method m2=c.getMethod("print");
            //m2.invoke(reflectTest2,new Object[]{});
            m2.invoke(reflectTest2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void print(int a, int b) {
        System.out.println(a + b);
    }

    public void print(String a, String b) {
        System.out.println(a.toUpperCase() + "," + b.toUpperCase());
    }

    public void print(){
        System.out.println("hello");
    }
}
