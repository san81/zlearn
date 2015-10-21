
package com.san.rest;

import java.util.Calendar;

public class TestMainDate {

    public static void main(String[] args) {
        
        Calendar previewDateCal  = Calendar.getInstance();
        previewDateCal.set(Calendar.YEAR,2015);
        previewDateCal.set(Calendar.MONTH,9);
        previewDateCal.set(Calendar.DATE,15);
        // Compare with the current date and fill in the flag 
        boolean isItForPastDays = Calendar.getInstance().compareTo(previewDateCal)>0;
        System.out.println(Calendar.getInstance().getTime());
        System.out.println(previewDateCal.getTime());
        System.out.println(Calendar.getInstance().compareTo(previewDateCal));
        System.out.println(isItForPastDays);
    }

}
