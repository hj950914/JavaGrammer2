package com.hj.javaSe.reflect.动态代理;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Author: hj
 * Date: 2019-03-27 16:51
 * Description: <动态代理测试类>
 */
public class Test {

    //动态代理测试
    @org.junit.jupiter.api.Test
    void testProxy(){
        //创建需要被代理的实例对象
        Student student=new Student("李四");
        //创建一个与代理对象相关联的InvocationHandler
        InvocationHandler stuHandler=new ProxyStu(student);
        //创建一个代理对象来处理"李四"
        //代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        Person stuProxy=(Person) Proxy.newProxyInstance(Student.class.getClassLoader(), new Class[]{Person.class},stuHandler);
        //代理执行Student类里的交班费方法
        stuProxy.giveMoney();
    }
}
