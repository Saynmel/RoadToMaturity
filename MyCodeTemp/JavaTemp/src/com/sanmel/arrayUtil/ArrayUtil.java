package com.sanmel.arrayUtil;

import java.util.*;

/**
 * @ Description: Java ArraysUtil 工具类
 * @ Author: yanhao
 * @ Date: 2018/10/25 10:08
 **/
public class ArrayUtil {

    private static final int INDEX_LONG = 10000000;

    private static int[] arrays = new int[INDEX_LONG];
    //    private static List<ObjectArray> objectArrays = new ArrayList<>();
    private static ObjectArray[] objectArrays = new ObjectArray[INDEX_LONG];

    public static void main(String[] args) {
        ArrayUtil util = new ArrayUtil();
        util.init();
        //打印出数组
        System.out.println(Arrays.toString(arrays));
        /**
         * 数组排序
         */
        Date startDate = new Date();
        Arrays.sort(arrays);
        Date endDate = new Date();
        System.out.println("耗时:" + (endDate.getTime() - startDate.getTime()));
        /**
         * 输出数组信息
         */
        System.out.println(Arrays.toString(arrays));
        util.initASCArray();
        System.out.println(Arrays.toString(arrays));
        /**
         * 二分法查找指定值的索引
         */
        int index = Arrays.binarySearch(arrays, 7);
        System.out.println(index);
        /**
         * 指定区间二分法查找指定值的索引
         */
        index = Arrays.binarySearch(arrays, 4, 10, 7);//
        System.out.println(index);
        /**
         * 对象数组排序
         */
        Arrays.sort(objectArrays, new ObjectArrayCompartor());//数组排序
        System.out.println(Arrays.toString(objectArrays));
        /**
         * 复制数组
         * newLength < oldLength :截取
         * newLength > oldLength : 0 ，null ,false 填充
         **/
        int[] a = Arrays.copyOf(arrays, 1500);
        System.out.println(Arrays.toString(a));
        /**
         * 数组数据填充
         */
        Arrays.fill(a, 1200, 1500, 500);
        System.out.println(Arrays.toString(a));
    }

    private void init() {
        for (int i = 0; i < INDEX_LONG; i++) {
            Random random = new Random();
            int randomInt = random.nextInt(10000);//在0~bound 之间随机产生数值
            arrays[i] = randomInt;
            ObjectArray objectArray = new ObjectArray();
            objectArray.setName("sanmel");
            objectArray.setAge(randomInt);
            objectArrays[i] = objectArray;
        }
    }

    private void initASCArray() {
        for (int i = 0; i < 1000; i++) {
            arrays[i] = i;
        }
    }
}

/**
 * 侵入式的排序
 */
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
        return this.getAge() - ((ObjectArray) o).getAge();
    }
}

/**
 * 非侵入式的排序
 */
class ObjectArrayCompartor implements Comparator<ObjectArray> {

    @Override
    public int compare(ObjectArray o1, ObjectArray o2) {
        return o1.getAge() - o2.getAge();
    }

}
