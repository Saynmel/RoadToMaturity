package com.sanmel.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ Description:
 * @ Author: yanhao
 * @ Date: 2018/8/22 10:00
 **/
public class DateExampl {
    private void transDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss:SSS");
        System.out.println(sdf.format(date));
    }

    public static void main(String[] args) {
        DateExampl dateExampl = new DateExampl();
        dateExampl.transDate();
    }
}
