package com.sanmel.thread;

/**
 * @ Description:
 * @ Author: yanhao
 * @ Date: 2018/8/28 16:49
 **/
public class JoinThread extends Thread {
    public JoinThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + "; i:" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new JoinThread("新线程").start();
        for (int i = 0; i < 100; i++) {
            if (i == 20) {
                JoinThread thread = new JoinThread("被Join的Thread");
                thread.start();
                thread.join();
            }
            System.out.println(Thread.currentThread().getName() + "; i=" + i);
        }
    }
}
