package com.sanmel.thread;

/**
 * @ Description:
 * @ Author: yanhao
 * @ Date: 2018/8/28 16:10
 **/
public class SecondThread implements Runnable {
    private int i;

    @Override
    public void run() {
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "; m =" + i);
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "; i =" + i);
            if (i == 10) {
                SecondThread st = new SecondThread();
                new Thread(st).start();
                new Thread(st).start();
            }
        }
    }
}
