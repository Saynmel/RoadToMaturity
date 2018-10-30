package com.sanmel.polymorphism;

/**
 * @ Description:
 * @ Author: yanhao
 * @ Date: 2018/10/30 10:45
 **/
public class BaseClass {

    public int book = 6;

    public void base() {
        System.out.println("父类的普通方法 -- BaseClass:base()");
    }

    public void test() {
        System.out.println("父类被覆盖的方法 -- BaseClass:test()");
    }
}
