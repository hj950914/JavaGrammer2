package com.hj.javaSe.reflect.注解;

/**
 * Author: hj
 * Date: 2019-03-27 13:06
 * Description: <描述>
 */
public interface Person {
    public String name();

    public int age();

    //方法过时
    @Deprecated
    public void sing();
}
