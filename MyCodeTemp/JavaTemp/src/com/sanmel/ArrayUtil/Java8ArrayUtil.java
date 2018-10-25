package com.sanmel.ArrayUtil;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * @ Description:
 * @ Author: yanhao
 * @ Date: 2018/10/25 17:15
 **/
public class Java8ArrayUtil {
    private static final int INDEX_LONG = 10000000;

    private static int[] arrays = new int[INDEX_LONG];

    public static void main(String[] args) {
        Java8ArrayUtil java8 = new Java8ArrayUtil();
        java8.init();
        /**
         * 并发排序
         */
        Date startDate = new Date();
        Arrays.parallelSort(arrays);
        Date endDate = new Date();

        System.out.println(Arrays.toString(arrays));
        System.out.println("排序耗时：" + (endDate.getTime() - startDate.getTime()));
        System.out.println("..............");
    }

    private void init() {
        for (int i = 0; i < INDEX_LONG; i++) {
            Random random = new Random();
            int randomInt = random.nextInt(1000);//在0~bound 之间随机产生数值
            arrays[i] = randomInt;
        }
    }
}
