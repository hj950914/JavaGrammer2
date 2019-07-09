package com.hj.javaSe.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: hj
 * Date: 2019-03-26 18:48
 * Description: <泛型的本质>
 */
public class ReflectTest3 {

    @Test
    public void testOne() {
        List list = new ArrayList();
        List<String> list1 = new ArrayList<>();
        Class c = list.getClass();
        Class c1 = list1.getClass();
        System.out.println(c == c1);//true

        //反射的操作都是编译之后的操作
        /*
         * c1==c2结果返回true,说明编译之后集合的泛型是去泛型化的
         * Java中集合的泛型,是防止错误输入的,只在编译阶段有效,绕过编译就无效了
         * 验证:我们可以通过方法的反射来操作,绕过编译(反射是在运行时刻加载)
         */
        Method m1 = null;
        try {
            m1 = c1.getMethod("add", Object.class);
            //绕过编译操作就绕过了泛型
            m1.invoke(list1, 1);
            System.out.println(list1.size());
            System.out.println("集合内容" + list1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
