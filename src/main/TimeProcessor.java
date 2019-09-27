package main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class TimeProcessor {
    private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm") ;
    public String getUTCTime(){
        StringBuffer UTCTimeBuffer = new StringBuffer();
        // 1、取得本地时间：
        Calendar cal = Calendar.getInstance() ;
        // 2、取得时间偏移量：
        int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
        // 3、取得夏令时差：
        int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
        // 4、从本地时间里扣除这些差量，即可以取得UTC时间：
        cal.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = (cal.get(Calendar.HOUR_OF_DAY));
        int minute = cal.get(Calendar.MINUTE);

        UTCTimeBuffer.append(year).append("-").append(month).append("-").append(day) ;
        UTCTimeBuffer.append(" ").append(hour).append(":").append(minute) ;
        try{
            format.parse(UTCTimeBuffer.toString()) ;
            return UTCTimeBuffer.toString() ;
        }catch(ParseException e)
        {
            e.printStackTrace() ;
        }
        return null ;
    }
    public static String addTime(String oldTime, int offset){
        java.util.Date oTime = null;
        String newTime = null;
        Calendar c = Calendar.getInstance();
        try{
            oTime = format.parse(oldTime);
            c.setTime(oTime);
            c.add(Calendar.HOUR_OF_DAY,offset);
            java.util.Date nDate = c.getTime();
            newTime = format.format(nDate);
            return newTime;
        }catch (ParseException e){
            throw new RuntimeException("The format of new time is wrong!");
        }

    }
    public static void main (String args[]){
        TimeProcessor tp = new TimeProcessor();
        String utc = tp.getUTCTime();
        String cTime = tp.addTime(utc,-12);

        System.out.println(utc);
        System.out.println(cTime);
    }
}
