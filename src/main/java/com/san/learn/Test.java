
package com.san.learn;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) {
        System.out.println(Integer.toHexString(97));
        System.out.println(Integer.toBinaryString(98));
        System.out.println(Integer.toBinaryString(99));
        System.out.println(Integer.toBinaryString(100));
        
        Long l = System.currentTimeMillis();
        l=1483815660000L-l;
        Long milliseconds = 1483815660000L;
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MILLISECOND, l.intValue());
        
        System.out.println(cal.getTime());
        
        int seconds = (int) (milliseconds / 1000) % 60 ;
        int minutes = (int) ((milliseconds / (1000*60)) % 60);
        int hours   = (int) ((milliseconds / (1000*60*60)) % 24);
        
        int days   = (int) ((milliseconds / (1000*60*60*24)) )%365;
        
        System.out.println(hours+":"+minutes+":"+seconds+": days "+days);
    }

}
