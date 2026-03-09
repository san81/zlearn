package com.san.weekly450;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class MinSwapsToSortByDigitSum {

    int digitSum(long d) {
        long original = d;
        int sum=0;
        while(d>0) {
            sum += d%10;
            d = d/10;
        }
        System.out.println(original +" : "+sum);
        return sum;
    }
    public int minSwaps(int[] nums) {
        Queue<Long> dsum = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                int diff = digitSum(o1) - digitSum(o2);
                if(diff==0) {
                    return (int)(o1-o2);
                }
                return diff;
            }
        });

        for(long n:nums) {
            dsum.add(n);
        }
        System.out.println(dsum);
        Iterator<Long> iterator = dsum.iterator();
        int diff = 0;
        int i=0;
        while(iterator.hasNext()) {
            if(nums[i] != iterator.next()) {
                diff++;
            }
            i++;
        }
        return diff/2;
    }

    public static void main(String[] args) {
        MinSwapsToSortByDigitSum mws = new MinSwapsToSortByDigitSum();
//        assertEquals(1, mws.minSwaps(new int[]{37,100}));
//        assertEquals(0, mws.minSwaps(new int[]{22,14,33,7}));
//        assertEquals(2, mws.minSwaps(new int[]{18,43,34,16}));
        assertEquals(2, mws.minSwaps(new int[]{268835996,65052660,415128775}));

    }
}
