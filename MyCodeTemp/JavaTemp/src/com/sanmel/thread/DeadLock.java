package com.sanmel.thread;

/**
 * @ Description:
 * @ Author: yanhao
 * @ Date: 2018/8/28 17:41
 **/
public class DeadLock implements Runnable {


    A a = new A();
    B b = new B();

    public void init() {
        Thread.currentThread().setName("主线程");
        a.foo(b);
        System.out.println("进入主线程之后");
    }

    @Override
    public void run() {
        Thread.currentThread().setName("副线程");
        b.bar(a);
        System.out.println("进入副线程之后");
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        new Thread(deadLock).start();
        deadLock.init();
    }
}

class A {
    public synchronized void foo(B b) {
        System.out.println("线程：" + Thread.currentThread().getName() + "; 进入Class A的 Foo()方法");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程：" + Thread.currentThread().getName() + " 试图调用Class B 的 Last() 方法");
        b.last();
    }

    public synchronized void last() {
        System.out.println("进入 Class A 的 Last()方法");
    }
}

class B {
    public synchronized void bar(A a) {
        System.out.println("线程：" + Thread.currentThread().getName() + "; 进入Class B的 bar()方法");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程：" + Thread.currentThread().getName() + " 试图调用Class A 的 Last() 方法");
        a.last();
    }

    public synchronized void last() {
        System.out.println("进入 Class B 的 Last()方法");
    }
}
