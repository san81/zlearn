
package com.san.learn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MySimpleDateFormat {

    public static void main(String[] args) throws ParseException {
        
        String originalString = "2014-04-07T23:52:54.000Z'";
        String exact="2014-04-07'T'23:52:54.000Z";
        String s="2007-09-25T15:40:51.0000000Z";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd\\''T'\\'HH:mm:ss.SSS'Z'");
        Date date = sdf.parse(exact);
       
        
        System.out.println(date);
    }

}
