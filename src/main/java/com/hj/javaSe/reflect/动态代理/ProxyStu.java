package com.hj.javaSe.reflect.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Author: hj
 * Date: 2019-03-27 16:42
 * Description: <学生的代理类,实现代理的2个重要成员InvocationHandler和Proxy>
 */
public class ProxyStu implements InvocationHandler {

    Student student;

    public ProxyStu(Student student) {
        this.student = student;
    }

    /*
     * proxy:代表动态代理对象
     * method:代表正在执行的方法
     * args:代表调用目标方法时传入的实参
     * */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //代理过程中插入另外一个功能
        System.out.println("我是执行代理之前插入的功能!");
        System.out.println("代理执行的方法:" + method.getName());
        //反射
        Object result = method.invoke(student, args);
        System.out.println("我是执行代理完成后插入的功能!");
        return result;
    }
}
