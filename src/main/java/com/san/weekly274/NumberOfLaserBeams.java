package com.san.weekly274;

import org.junit.Assert;

public class NumberOfLaserBeams {
    public int numberOfBeams(String[] bank) {
        int sum=0;
        int prev=0;
        for(String s:bank){
            int laserCount = 0;
            for(char c:s.toCharArray()){
                if(c=='1'){
                    laserCount++;
                }
            }
            sum+=prev*laserCount;
            if(laserCount!=0)
                prev = laserCount;
        }
        return sum;
    }

    public static void main(String[] args) {
        NumberOfLaserBeams nolb = new NumberOfLaserBeams();
        Assert.assertEquals(nolb.numberOfBeams(new String[]{"011001","000000","010100","001000"}),8);
        Assert.assertEquals(nolb.numberOfBeams(new String[]{"000","111","000"}),0);

    }
}
