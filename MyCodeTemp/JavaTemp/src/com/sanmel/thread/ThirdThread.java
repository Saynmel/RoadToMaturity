package com.sanmel.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ Description:
 * @ Author: yanhao
 * @ Date: 2018/8/28 16:15
 **/
public class ThirdThread {
    public static void main(String[] args) {
        ThirdThread tt = new ThirdThread();
        FutureTask<Integer> task = new FutureTask<Integer>((Callable<Integer>) () -> {
            int i = 0;
            for (; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + "; i:" + i);
            }
            return i;
        });
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "; i:" + i);
            if (i == 10) {
                //实质还是以Callable对象来创建并启动线程
                new Thread(task).start();
            }

        }
        try {
            System.out.println("子线程返回的值：" + task.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
