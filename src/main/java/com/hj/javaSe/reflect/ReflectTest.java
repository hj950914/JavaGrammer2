package com.hj.javaSe.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;


/**
 * Author: hj
 * Date: 2019-03-26 09:24
 * Description: <java反射基础>
 */
public class ReflectTest {

    /*
     * 获取类加载器
     * AppClassLoader(自定义类加载器)
     * BootstrapClassLoader(用来加载Java的核心库(jre/lib/rt.jar)，是用原生C++代码来实现的)
     * ExtensionsClassLoader(用来加载 Java 的扩展库(jre/ext/*.jar))
     * */
    @Test
    void testReflectOne() {
        ReflectTest reflectTest = new ReflectTest();
        //自定义类加载器
        System.out.println(reflectTest.getClass().getClassLoader());
        //java自带类加载器
        System.out.println(String.class.getClassLoader());
    }

    /*
     * Class类的使用
     * */
    @Test
    void testTwo() {
        //任何一个类都是Class的实例对象,这个实例对象有三种表示方式
        /*
         * c1和c2表示了ReflectTest类的类类型(class type)
         * 万事万物皆对象
         * 类也是对象,是Class类的实例对象
         * 这个对象我们称为该类的类类型
         * */
        //第一种
        Class c1 = ReflectTest.class;
        //第二种
        Class c2 = new ReflectTest().getClass();
        //第三种
        Class c3 = null;
        try {
            c3 = Class.forName("com.hj.javaSe.reflect.ReflectTest");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //我们完全可以通过类的类类型创建该类的对象实例
        //也就是,可以通过c1,c2,c3创建ReflectTest类的实例
        try {
            //创建ReflectTest类实例对象
            ReflectTest reflectTest = (ReflectTest) c1.newInstance();
            //调用ReflectTest类里面的方法
            reflectTest.testReflectOne();

        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /*
     * 获取类的成员方法信息
     * */
    @Test
    void testThree() {
        //int的类类型
        Class c1 = int.class;
        //String的类类型
        Class c2 = String.class;
        Class c3 = double.class;
        Class c4 = Double.class;
        Class c5 = void.class;
        Class c6 = Package.class;

        //打印类的名称
        //System.out.println(c1.getName());
        //System.out.println(c2.getName());

        /*
         *获取类的全部信息
         * */
        Class c = Integer.class;
        //获取类的名称
        System.out.println("类的名称是:" + c.getName());
        /*
         * Method类,方法对象
         * 一个成员方法就是一个Method对象
         * getMethods()方法获取的是所有的public的函数,包括父类继承而来的
         * getDeclaredMethods()获取的是所有该类自己声明的方法
         * */
        Method[] ms = c.getDeclaredMethods();
        for (Method method : ms) {
            //得到方法返回值(int,String...)类型的类类型
            Class returnType = method.getReturnType();
            System.out.print("方法返回值类型是:" + returnType.getName() + " ");
            //得到方法名
            System.out.print(method.getName() + "(");
            //获取参数类型,得到的是参数列表的类型的类类型
            Class[] parameterTypes = method.getParameterTypes();
            for (Class class1 : parameterTypes) {
                System.out.print(class1.getName() + ",");
            }
            System.out.println(")");
        }
    }

    /*
     * 获取类的成员变量(成员变量也是对象)
     * java.lang.reflect.Field
     * Field类封装了关于关于成员变量的操作
     * getFields()方法获取的是所有public的成员变量信息
     * getDeclaredFields()获取自己声明的成员变量信息
     * */
    @Test
    void testFour() {
        //获取类的类类型
        Class c = Integer.class;
        //获取成员变量存入数组
        Field[] fs = c.getDeclaredFields();
        for (Field field : fs) {
            //得到成员变量的类型的类类型
            Class fieldType = field.getType();
            //得到成员变量的类型(类型名称)
            String typeName = fieldType.getName();

            //得到成员变量的名称
            String fieldName = field.getName();

            System.out.println(typeName + " " + fieldName);
        }
    }

    /*
     * 获取类的构造函数信息
     * java.lang.reflect.Constructor中封装了构造函数的信息
     * getConstructors()获取所有的public的
     * getDeclaredConstructors()得到的是所有构造方法
     * */
    @Test
    void testFive() {
        Class c = Collections.class;
        Constructor[] cs = c.getConstructors();
        for (Constructor constructor : cs) {
            //获取构造方法名称
            System.out.print(constructor.getName() + "（");
            //获取构造函数的参数列表,得到的是参数列表的类类型
            Class[] parameterTypes = constructor.getParameterTypes();
            for (Class class1 : parameterTypes) {
                //获取类型名称
                System.out.print(class1.getName() + " ,");
            }
            System.out.println(")");
        }
    }


}
