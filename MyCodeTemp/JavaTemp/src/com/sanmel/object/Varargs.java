package com.sanmel.object;

/**
 * @ Description:
 * @ Author: yanhao
 * @ Date: 2018/10/29 11:51
 **/
public class Varargs {
    public static void main(String[] args) {
        test(55, "yanhao", "sanmel", "com.sanmel.object");
    }

    /**
     * 定义形参个数可变的方法
     *
     * @param a
     * @param books
     */
    private static void test(int a, String... books) {
        //把books当作数组处理
        for (String book : books) {
            System.out.println(book);
        }
        System.out.println(a);
    }
}
