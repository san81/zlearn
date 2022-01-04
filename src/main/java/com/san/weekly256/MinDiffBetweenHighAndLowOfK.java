package com.san.weekly256;

import org.junit.Assert;

import java.util.Arrays;

public class MinDiffBetweenHighAndLowOfK {
    public int minimumDifference(int[] nums, int k) {
        if(nums.length==1)
            return 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++) {
            if((i+k-1)<nums.length && min>(nums[i+k-1]-nums[i])) {
                min = nums[i+k-1]-nums[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinDiffBetweenHighAndLowOfK mdb = new MinDiffBetweenHighAndLowOfK();
        Assert.assertEquals(0, mdb.minimumDifference(new int[]{90}, 1));
        Assert.assertEquals(74560, mdb.minimumDifference(new int[]{87063,61094,44530,21297,95857,93551,9918},6));
    }
}
