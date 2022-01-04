package com.san.weekly272;

import org.junit.Assert;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SmoothDescentPeriodsOfAStock {
    public long getDescentPeriods(int[] prices) {
        long lstIdx = 1;
        long lastValue = prices[0];
        long seqCountToEmit = 0;
        long result = 0;
        for(int i=1;i<prices.length+1;i++){
            if(i<prices.length && lastValue-prices[i]==1){
                lstIdx++;
            }else{
                //resetting point
                seqCountToEmit+= lstIdx;
                result += ((lstIdx * (lstIdx+1))/2);
                lstIdx=1;
            }
            if(i<prices.length)
                lastValue = prices[i];
        }
        result += prices.length - seqCountToEmit;
        return result;
    }

    public static void main(String[] args) {
        SmoothDescentPeriodsOfAStock sdp = new SmoothDescentPeriodsOfAStock();
        Assert.assertEquals(sdp.getDescentPeriods(new int[]{3,2,1,4}),7);
        Assert.assertEquals(sdp.getDescentPeriods(new int[]{8,6,7,7}),4);
        Assert.assertEquals(sdp.getDescentPeriods(new int[]{1}),1);
        Assert.assertEquals(sdp.getDescentPeriods(new int[]{12,11,10,9,8,7,6,5,4,3,4,3,10,9,8,7}),68);
    }
}
