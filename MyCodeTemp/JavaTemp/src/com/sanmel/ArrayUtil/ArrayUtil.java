package com.sanmel.ArrayUtil;

import java.util.Arrays;
import java.util.Random;

/**
 * @ Description:
 * @ Author: yanhao
 * @ Date: 2018/10/25 10:08
 **/
public class ArrayUtil {


    private static int[] arrays = new int[1000];

    public static void main(String[] args) {
        ArrayUtil util = new ArrayUtil();
        util.init();
        //打印出数组
        System.out.println(Arrays.toString(arrays));
        Arrays.sort(arrays);//数组排序
        System.out.println(Arrays.toString(arrays));
        util.initASCArray();
        System.out.println(Arrays.toString(arrays));
        int index = Arrays.binarySearch(arrays, 7);//二分法查找索引
        System.out.println(index);
        index = Arrays.binarySearch(arrays, 4, 10, 7);//指定区间二分法查找
        System.out.println(index);
    }

    private void init() {
        for (int i = 0; i < 1000; i++) {
            Random random = new Random();
            int randomInt = random.nextInt(4);//在0~bound 之间随机产生数值
            arrays[i] = randomInt;
        }
    }

    private void initASCArray() {
        for (int i = 0; i < 1000; i++) {
            arrays[i] = i;
        }
    }
}

class ObjectArray implements Comparable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ObjectArray{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        ObjectArray temp = (ObjectArray) o;
        if (this.age < temp.getAge()) {
            return -1;
        } else if (this.age > temp.getAge()) {
            return 1;
        } else {
            return 0;
        }
    }
}
