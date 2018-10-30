package com.sanmel.polymorphism;

/**
 * @ Description:
 * @ Author: yanhao
 * @ Date: 2018/10/30 10:46
 **/
public class SubClass extends BaseClass {
    public String book = "Hello World -- Java";

    public void test() {
        System.out.println("子类覆盖父类的方法--SubClass:test()");
    }

    public void sub() {
        System.out.println("子类的普通方法--SubClass:sub()");
    }

    public static void main(String[] args) {
        BaseClass baseClass = new BaseClass();
        System.out.println("BaseClass -- book:" + baseClass.book);
        baseClass.base();
        baseClass.test();
        System.out.println();
        SubClass subClass = new SubClass();
        System.out.println("SubClass -- book:" + subClass.book);
        subClass.sub();
        subClass.test();
        System.out.println();

        //多态性出现
        BaseClass polyClass = new SubClass();
        System.out.println("polyClass -- book:" + polyClass.book);
        polyClass.base();
//        polyClass.sub();
        polyClass.test();
    }
}
