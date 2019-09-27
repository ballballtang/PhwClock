package main;

import java.text.ParseException;
import java.util.Scanner;
import java.util.concurrent.CyclicBarrier;

public class PhwClockUI {
    CityClock[] clocks = new CityClock[5];
    PhoneClock phone;
    int operation = 0;

    public PhwClockUI(){
        //初始化五个城市的时钟，输入城市名和相对北京时间的偏移量
        clocks[0] = new CityClock("BeiJing",0);
        clocks[1] = new CityClock("London",-8);
        clocks[2] = new CityClock("Moscow",-4);
        clocks[3] = new CityClock("Sydney",2);
        clocks[4] = new CityClock("NewYork",-13);
        //初始化手机时钟
        phone = new PhoneClock();
    }

    public void lookTime(){
        System.out.println("The time of phone is: "+this.phone.getTime());
        for(int i=0;i<5;i++) {
            String t = this.clocks[i].getTime();
            String c = this.clocks[i].getCity();
            System.out.println("The time of city " + c + " is: " + t);
        }
    }

    public void changeTime(String nt){
        this.phone.changeTime(nt,this.clocks);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        PhwClockUI clockUI = new PhwClockUI();
        System.out.println("Please choose the operation: ");
        System.out.println("1: Look the time.");
        System.out.println("2: Modify the time.");
        clockUI.operation = sc.nextInt();
        if(clockUI.operation == 1){
            clockUI.lookTime();
        }else if(clockUI.operation == 2){
            System.out.println("Please input the new time.(yyyy-MM-dd HH:mm)");
            sc.nextLine();
            String newTime = sc.nextLine();
            clockUI.changeTime(newTime);
            System.out.println("The clocks have been modified: ");
            clockUI.lookTime();
        }else{
            System.out.println("Please input the correct number of operation.");
        }
    }
}
