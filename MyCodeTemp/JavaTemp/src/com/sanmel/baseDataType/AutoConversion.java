package com.sanmel.baseDataType;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ Description:
 * @ Author: yanhao
 * @ Date: 2018/9/15 16:58
 **/
public class AutoConversion {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
        int a = 6;
        float b = a;
        double c = a;
        long d = a;
        System.out.println("a:" + a);
        System.out.println("b:" + b);
        System.out.println("c:" + c);
        System.out.println("d:" + d);
        String str = "http://oss.dev.yocaigs.com:89/osspath/html/autd/[op_company_id]/bak_sql";
        String dyStr = str.substring(str.indexOf("["), str.lastIndexOf("]") + 1);
        str = str.replace(dyStr, "abc");
        System.out.println(str);
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println(inetAddress.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        System.out.println(sdf.format(calendar.getTime()));
        calendar.setTime(new Date());
        System.out.println(sdf.format(calendar.getTime()));
        calendar.add(Calendar.DATE,-1);
        System.out.println(sdf.format(calendar.getTime()));
        System.out.println();
    }
}
