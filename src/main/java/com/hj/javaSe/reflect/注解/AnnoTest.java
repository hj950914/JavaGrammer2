package com.hj.javaSe.reflect.注解;

import org.junit.jupiter.api.Test;

/**
 * Author: hj
 * Date: 2019-03-27 13:04
 * Description: <注解测试1>
 */
public class AnnoTest {

    //@SuppressWarnings("Deprecated")忽略警告Deprecated过时注解
    @SuppressWarnings("Deprecated")
    @Test
    public void testOne(){
        Person person=new Child();
        person.sing();
    }
}
