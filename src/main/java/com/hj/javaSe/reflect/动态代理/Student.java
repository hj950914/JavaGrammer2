package com.hj.javaSe.reflect.动态代理;

/**
 * Author: hj
 * Date: 2019-03-27 16:38
 * Description: <学生类,实现Person接口>
 */
public class Student implements Person {

    //姓名
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //交班费
    @Override
    public void giveMoney() {
        System.out.println(this.getName()+"交了60元班费");
    }
}
