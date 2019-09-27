package main;

public class CityClock {

    String city;     //城市名
    int offset = 0;  //相对北京时间的时间差
    String localTime;     //地方时间
    TimeProcessor tp = new TimeProcessor();

    public CityClock(String c , int o){
        this.city = c;
        this.offset = o;
        //初始化当地时间
        String UTC = tp.getUTCTime();
        this.localTime = tp.addTime(UTC , o+8); //北京时间比UTC时间早八个小时，所以用偏移量加上8
    }

    public String getTime(){
        return this.localTime;
    }

    public String getCity(){
        return this.city;
    }

    public void changeTime(String time){
        this.localTime = tp.addTime(time,this.offset);
    }


}
