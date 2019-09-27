package main;

public class PhoneClock {

    String phoneTime;
    TimeProcessor tp = new TimeProcessor();

    public PhoneClock(){
        String UTC = tp.getUTCTime();
        this.phoneTime = tp.addTime(UTC , 8);
    }

    public String getTime(){
        return this.phoneTime;
    }

    public void changeTime(String time,CityClock[] cc){

        for(int i=0;i<5;i++){
            cc[i].changeTime(time);
        }
        this.phoneTime = time;
    }
}
