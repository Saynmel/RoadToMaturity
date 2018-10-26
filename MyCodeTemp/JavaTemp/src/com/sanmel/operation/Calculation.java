package com.sanmel.operation;

/**
 * @ Description:运算
 * @ Author: yanhao
 * @ Date: 2018/10/25 10:36
 **/
public class Calculation {
    public static void main(String[] args) {
        Calculation cal = new Calculation();
        cal.initDate();//初始化数据
        cal.decimalTran();//进制转换
        cal.calAnd();// “ & ”  与运算
        cal.calOr();// “ | ” 或运算
        cal.calUn();// “ ~ ” 非运算
        cal.calXor();// “ ^ ” 异或运算
        cal.calLeftDisplace();// “ << ” 左位移运算
        cal.calRightDisplace();// “ >> ” 右位移运算
        cal.calRightDisplacePlus();// “ >>> ” 无符号位右位移运算
    }

    /**
     * 初始化数据
     */
    private void initDate() {
        System.out.println("-------------initDate(初始化数据)-------------");
        int intMax = Integer.MAX_VALUE;
        int intMin = Integer.MIN_VALUE;
        String binaryMax = Integer.toBinaryString(intMax);
        String binaryMin = Integer.toBinaryString(intMin);
        System.out.println("int 最大值: " + intMax + ";--> binaryInt: " + binaryMax);
        System.out.println("int 最小值:" + intMin + ";--> binaryInt:" + binaryMin);
        int a = 43210;
        Integer b = 043210;//八进制 0 开头
        Integer d = Integer.parseInt("43210", 8);
        Integer c = 0x43210;//十六进制 0x 开头
        Integer e = Integer.parseInt("43210", 16);
        System.out.println("43210 -- 十进制(43210):" + a);
        System.out.println("043210 -- 八进制(43210):" + b + "-----> d:" + d);
        System.out.println("0x43210 -- 十六进制(43210):" + c + "-----> e:" + e);
    }

    /**
     * 进制转换
     */
    private void decimalTran() {
        System.out.println("-------------decimalTran(进制转换)-------------");
        int a = 1667649452;//十进制
        String binaryStr = Integer.toBinaryString(a);//十进制转二进制
        String octalStr = Integer.toOctalString(a);//十进制转八进制
        String hexStr = Integer.toHexString(a);//十进制转十六进制
        int binaryInt = Integer.parseInt(binaryStr, 2);//二进制转十进制
        int octalInt = Integer.parseInt(octalStr, 8);//八进制转十进制
        int hexInt = Integer.parseInt(hexStr, 16);//十六进制转十进制
        System.out.println("a -- 二进制:" + binaryStr + ";--> binaryInt:" + binaryInt);
        System.out.println("a -- 八进制:" + octalStr + ";--> octalInt:" + octalInt);
        System.out.println("a -- 十六进制:" + hexStr + ";--> hexInt:" + hexInt);
    }

    /**
     * & 与运算
     * 二进制位上
     * 同位上都为1，结果才为1，否则结果为0
     */
    private void calAnd() {
        System.out.println("-------------calVersus(& 与运算)-------------");
        int a = 128;//binary:10000000
        System.out.println("a -- binary:" + Integer.toBinaryString(a));//二进制
        int b = 129;//binary:10000001
        System.out.println("b -- binary:" + Integer.toBinaryString(b));//二进制
        int c = a & b;
        System.out.println("a & b = " + c + "---> binaryInt :" + Integer.toBinaryString(c));
    }

    /**
     * | 或运算
     * 同位上只要有一个为1，结果就为1，否则结果为0
     */
    private void calOr() {
        System.out.println("-------------calOr(| 或运算)-------------");
        int a = 128;//binary:10000000
        System.out.println("a -- binary:" + Integer.toBinaryString(a));//二进制
        int b = 129;//binary:10000001
        System.out.println("b -- binary:" + Integer.toBinaryString(b));//二进制
        int c = a | b;
        System.out.println("a & b = " + c + "---> binaryInt :" + Integer.toBinaryString(c));
    }

    /**
     * ~ 非运算
     * 如果位为0，结果是1，如果位为1，结果是0，
     * 总结：
     * Step1：+1
     * Step2:取反
     */
    private void calUn() {
        System.out.println("-------------calUn(~ 非运算)-------------");
        int a = 127;
        System.out.println("a -- binary:" + Integer.toBinaryString(a));//二进制
        int b = ~a;
        System.out.println(" ~a = " + b + "---> binaryInt :" + Integer.toBinaryString(b));
    }

    /**
     * ^ 异或运算
     * 两个操作数的位中，相同则结果为0，不同则结果为1
     */
    private void calXor() {
        System.out.println("-------------calXor(^ 异或运算)-------------");
        int a = 128;//binary:10000000
        System.out.println("a -- binary:" + Integer.toBinaryString(a));//二进制
        int b = 129;//binary:10000001
        System.out.println("b -- binary:" + Integer.toBinaryString(b));//二进制
        int c = a ^ b;
        System.out.println("a & b = " + c + "---> binaryInt :" + Integer.toBinaryString(c));
    }

    /**
     * << 左位移运算
     * 针对二进制，转换成二进制后向左移动3位，后面用0补齐
     * 总结：左移多少(n)位 就 原数 a * 2^n
     */
    private void calLeftDisplace() {
        System.out.println("-------------calLeftDisplace(<< 左位移运算)-------------");
        int a = 7;
        System.out.println("a = " + a + "-- binary:" + Integer.toBinaryString(a));//二进制
        int b = a << 3;
        System.out.println(" a << 2 = " + b + "---> binaryInt :" + Integer.toBinaryString(b));
    }

    /**
     * >> 右位移运算
     * 针对二进制，转换成二进制后向右移动3位，正数用0补齐  负数用1
     * 总结：
     * 正数：
     * 原数字 a  位移数 n
     * 原数字（a）大于 2^n
     * 右移多少位 就 a/(2^n)
     */
    private void calRightDisplace() {
        System.out.println("-------------calRightDisplace(>> 右位移运算)-------------");
        int a = -9;
        System.out.println("a = " + a + "-->            binary:" + Integer.toBinaryString(a));//二进制
        int b = a >> 3;
        System.out.println(" a >> 2 = " + b + "---> binaryInt :" + Integer.toBinaryString(b));
    }

    /**
     * >>> 无符号右位移运算 忽略符号位，空位都以0补齐
     * 正数的  >>  >>>  运算相同
     */
    private void calRightDisplacePlus() {
        System.out.println("-------------calRightDisplacePlus(>>> 右位移运算)-------------");
        int a = -9;
        System.out.println("a = " + a + "-->                    binary:" + Integer.toBinaryString(a));//二进制
        int b = a >>> 3;
        System.out.println(" a >>> 2 = " + b + "---> binaryInt :" + Integer.toBinaryString(b));
    }
}
