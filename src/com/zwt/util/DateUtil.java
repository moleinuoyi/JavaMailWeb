package com.zwt.util;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static String getDate(){
        Calendar calendar=Calendar.getInstance();
        int y=calendar.get(Calendar.YEAR);
        int m=calendar.get(Calendar.MONTH);
        int d=calendar.get(Calendar.DATE);
        int h=calendar.get(Calendar.HOUR);
        int mi=calendar.get(Calendar.MINUTE);
        int s=calendar.get(Calendar.SECOND);
        StringBuffer sb=new StringBuffer("");
        sb.append(y);
        sb.append(m+1);
        sb.append(d);
        sb.append(h);
        sb.append(mi);
        sb.append(s);
        String date=sb.toString();
        return date;
    }
    
    public static String getDirDate(){
        Calendar calendar=Calendar.getInstance();
        int y=calendar.get(Calendar.YEAR);
        int m=calendar.get(Calendar.MONTH);
        int d=calendar.get(Calendar.DATE);
        StringBuffer sb=new StringBuffer("");
        sb.append(y);
        sb.append(m+1);
        sb.append(d);
        String date=sb.toString();
        return date;
    }
    public static String getTimeDriDate() {
    	Date date = new Date();
    	return String.valueOf(date.getTime());
    }
}