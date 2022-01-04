package com.san.google.arrays;

import org.junit.Assert;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Next Closest Time
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.
 *
 * You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.
 *
 *
 *
 * Example 1:
 *
 * Input: time = "19:34"
 * Output: "19:39"
 * Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.
 * It is not 19:33, because this occurs 23 hours and 59 minutes later.
 * Example 2:
 *
 * Input: time = "23:59"
 * Output: "22:22"
 * Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22.
 * It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
 *
 *
 * Constraints:
 *
 * time.length == 5
 * time is a valid time in the form "HH:MM".
 * 0 <= HH < 24
 * 0 <= MM < 60
 */
public class NextClosesTime {

    public String makeTime(int hr, int min) {
        String strHr = hr <= 9? ("0"+hr) : hr+"";
        String strMin = min <= 9? ("0"+min) : min+"";
        return strHr+":"+strMin;
    }

    public boolean isAllDigitsPresent(int nextMin, Set<Integer> allDigits ){

        //see if digits are in all digits
        while(nextMin>0){
            int d = nextMin%10;
            if(!allDigits.contains(d)) {
                return false;
            }
            nextMin = nextMin/10;
        }
        return true;
    }
    public String nextClosestTime(String time) {
        String[] hrmin = time.split(":");
        Set<Integer> allDigits = new TreeSet<>();
        for(char c:time.toCharArray()){
            allDigits.add(c-'0');
        }
        int hr = Integer.parseInt(hrmin[0]);
        int min = Integer.parseInt(hrmin[1]);
        int nextMin = min;
        int nextHr = hr;
        //Try with in the hour going above in minutes - until the day ends
        //Try going above in hours
        while(nextHr<24){
            while(nextMin<59) {
                nextMin++;
                if(nextMin<10 && !allDigits.contains(0)) continue;
                if(isAllDigitsPresent(nextMin, allDigits)){
                    return makeTime(nextHr, nextMin);
                }
            }

            nextHr++;
            while(!isAllDigitsPresent(nextHr, allDigits) && nextHr<24) nextHr++;
            nextMin = -1;
        }
        //Going into the Next day so start from the smallest hour smallest minutes
        //Start with the smallest non zero number and repeat it
        Iterator<Integer> digitItr = allDigits.iterator();
        int smallest = digitItr.next();
        int smallHr = smallest*10+smallest;
        int smllMin = smallest*10+smallest;

        return makeTime(smallHr, smllMin);
    }

    public static void main(String[] args) {
        NextClosesTime nct = new NextClosesTime();
        System.out.println(nct.nextClosestTime("23:59"));
        Assert.assertEquals(nct.nextClosestTime("19:34"),"19:39");
        Assert.assertEquals(nct.nextClosestTime("23:59"),"22:22");
        Assert.assertEquals(nct.nextClosestTime("01:32"),"01:33");
        Assert.assertEquals(nct.nextClosestTime("13:55"),"15:11");
        Assert.assertEquals(nct.nextClosestTime("20:48"),"22:00");
        Assert.assertEquals(nct.nextClosestTime("09:26"),"09:29");
    }

}
