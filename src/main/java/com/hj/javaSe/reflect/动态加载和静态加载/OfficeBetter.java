package com.hj.javaSe.reflect.动态加载和静态加载;

/**
 * Author: hj
 * Date: 2019-03-26 15:45
 * Description: <动态加载，（这个类不用更改,只需要编译一次）>
 */
public class OfficeBetter {
    /*
     * 运行
     * 运行时刻加载类是动态加载类
     * */
    public static void main(String[] args) {
        try {
            //动态加载类,在运行时刻
            Class c= Class.forName(args[0]);
            //通过类类型,创建该类对象
            OfficeAble oa=(OfficeAble) c.newInstance();
            oa.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
