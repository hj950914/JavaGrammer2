package com.hj.javaSe.reflect.动态加载和静态加载;

/**
 * Author: hj
 * Date: 2019-03-26 15:35
 * Description: <当前类为静态加载。OfficeBetter类里面的案例是动态加载>
 */
public class Office {
    /*
     * 编译
     * 编译时刻加载类是静态加载类
     * */
    public static void main(String[] args){
        //new 创建对象是静态加载类,在编译时刻就需要加载所有的可能使用到的类
        //通过动态加载类可以解决该问题
        if ("Word".equals(args[0])){
            Word w=new Word();
            w.start();
        }
        if ("Excel".equals(args[0])){
            //Excel e=new Excel();
            //e.start();
        }
    }
}
