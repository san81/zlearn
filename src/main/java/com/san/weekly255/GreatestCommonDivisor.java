package com.san.weekly255;

import org.junit.Assert;

/**
 * 5850. Find Greatest Common Divisor of Array
 * Given an integer array nums, return the greatest common divisor of the smallest number and largest number in nums.
 *
 * The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,5,6,9,10]
 * Output: 2
 * Explanation:
 * The smallest number in nums is 2.
 * The largest number in nums is 10.
 * The greatest common divisor of 2 and 10 is 2.
 * Example 2:
 *
 * Input: nums = [7,5,6,8,3]
 * Output: 1
 * Explanation:
 * The smallest number in nums is 3.
 * The largest number in nums is 8.
 * The greatest common divisor of 3 and 8 is 1.
 * Example 3:
 *
 * Input: nums = [3,3]
 * Output: 3
 * Explanation:
 * The smallest number in nums is 3.
 * The largest number in nums is 3.
 * The greatest common divisor of 3 and 3 is 3.
 *
 */
public class GreatestCommonDivisor {
    public int findGCD(int[] nums) {
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        for(int i:nums) {
            if(min>i) {
                min=i;
            }
            if(max<i) {
                max = i;
            }
        }

        int commonDivisor = min;
        while(commonDivisor>1 && (min%commonDivisor!=0 || max%commonDivisor!=0)){
            commonDivisor--;
        }
        return commonDivisor;
    }

    public static void main(String[] args) {
        GreatestCommonDivisor greatestCommonDivisor = new GreatestCommonDivisor();
        Assert.assertEquals(2, greatestCommonDivisor.findGCD(new int[]{2,5,6,9,10}));
        Assert.assertEquals(3, greatestCommonDivisor.findGCD(new int[]{3,3}));

    }
}
