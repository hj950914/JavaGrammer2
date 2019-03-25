package com.hj.javaSe.JDK;

import org.junit.jupiter.api.Test;

/**
 * Author: hj
 * Date: 2019-03-25 14:35
 * Description: <异常案例>
 */
public class ExceptionDemo {

    @Test
    void testOne() {
        try {
            int i = 100/0;
            System.out.println(i);
        } catch (Exception e) {
            System.out.println(1);
            //throw new RuntimeException();
        } finally {
            System.out.println(2);
        }
        System.out.println(3);
    }

}
