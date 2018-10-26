package com.sanmel.practice;

/**
 * @ Description: 数字转人民币读法
 * @ Author: yanhao
 * @ Date: 2018/10/26 10:36
 **/
public class Num2RMB {
    private static final double AMOUNT = 1000000000000001.92;

    private static final String[] ARRAY_NUM = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

    private static final String[] ARRAY_UNIT = {"十", "佰", "仟"};

    private static final String[] ARRAY_DECIMAL = {"分", "角"};

    public static void main(String[] args) {
        Num2RMB rmb = new Num2RMB();
        String[] money = rmb.divide();
        String intNum = rmb.calIntNum(money[0]);
        String doubleNum = rmb.calDoubleNum(money[1]);
        System.out.println(String.format("AMOUT:%f--->%s", AMOUNT, intNum + doubleNum));
    }

    private String[] divide() {
        long intNum = (long) AMOUNT;//获取正数部分数值
        long doubleNum = Math.round((AMOUNT - intNum) * 100);//获取两位小数数值
        return new String[]{String.valueOf(intNum), String.valueOf(doubleNum)};
    }

    /**
     * 计算整数部分
     *
     * @param intNum
     * @return
     */
    private String calIntNum(String intNum) {
        StringBuilder sb = new StringBuilder(intNum);
        sb.reverse();
        StringBuilder result = new StringBuilder();
        result.append("元");
        for (int i = 0; i < sb.length(); i++) {
            if ((i + 1) % 4 == 1) {
                int unit = (i + 1) / 4;
                switch (unit) {
                    case 0:
                        break;
                    case 1:
                        result.append("万");
                        break;
                    case 2:
                        result.append("亿");
                        break;
                    case 3:
                        result.append("亿万");
                        break;
                    default:
                }
            }
            int charVal = Integer.valueOf(String.valueOf(sb.charAt(i)));
            if ((i + 1) % 4 == 0 && charVal != 0) {
                result.append(ARRAY_UNIT[2]);
            } else if ((i + 1) % 4 == 3 && charVal != 0) {
                result.append(ARRAY_UNIT[1]);
            } else if ((i + 1) % 4 == 2 && charVal != 0) {
                result.append(ARRAY_UNIT[0]);
            }
            if (charVal != 0) {
                String numVal = ARRAY_NUM[charVal];
                result.append(numVal);
            }
            if (charVal == 0 && (i + 1) % 4 != 1) {
                String numVal = ARRAY_NUM[charVal];
                result.append(numVal);
            }
        }
        return result.reverse().toString();
    }

    private String calDoubleNum(String doubleNum) {
        StringBuilder sb = new StringBuilder(doubleNum);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            int charVal = Integer.valueOf(String.valueOf(sb.charAt(i)));
            if (charVal != 0) {
                String numVal = ARRAY_NUM[charVal];
                result.append(numVal);
                result.append(ARRAY_DECIMAL[i]);
            }
        }
        return result.toString();
    }
}
