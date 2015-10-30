
package com.san.rest;

import java.util.Calendar;

import org.joda.time.DateTime;

public class TestMainDate {

    public static void main(String[] args) {
        
        Calendar previewDateCal  = Calendar.getInstance();
        previewDateCal.set(Calendar.YEAR,2015);
        previewDateCal.set(Calendar.MONTH,9);
        previewDateCal.set(Calendar.DATE,22);
       
        previewDateCal.set(Calendar.HOUR, 0);
        
        
        Calendar today=Calendar.getInstance();
        today.set(Calendar.HOUR, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);
        
        DateTime pwdt = new DateTime(previewDateCal.getTime());
        DateTime tddt = new DateTime(today.getTime());
        // Compare with the current date and fill in the flag 
        boolean isItForPastDays = pwdt.isAfter(tddt); 
        System.out.println(pwdt.isEqual(tddt));
        System.out.println(previewDateCal.getTimeInMillis());
        System.out.println(Calendar.getInstance().compareTo(previewDateCal));
        System.out.println(isItForPastDays);
    }

}
