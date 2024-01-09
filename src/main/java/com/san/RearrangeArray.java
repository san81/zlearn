package com.san;

import org.junit.Assert;

import java.util.Arrays;

/**
 * You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
 *
 * You should rearrange the elements of nums such that the modified array follows the given conditions:
 *
 * Every consecutive pair of integers have opposite signs.
 * For all integers with the same sign, the order in which they were present in nums is preserved.
 * The rearranged array begins with a positive integer.
 * Return the modified array after rearranging the elements to satisfy the aforementioned conditions.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,1,-2,-5,2,-4]
 * Output: [3,-2,1,-5,2,-4]
 * Explanation:
 * The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
 * The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
 * Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.
 * Example 2:
 *
 * Input: nums = [-1,1]
 * Output: [1,-1]
 * Explanation:
 * 1 is the only positive integer and -1 the only negative integer in nums.
 * So nums is rearranged to [1,-1].
 */
public class RearrangeArray {
    public int[] rearrangeArray(int[] nums) {
        int p=0, n=0;
        int idx=0;
        int holding = nums[0];
        boolean toggle = true;

        for(int i=0;i<nums.length;i+=2) {
            while(nums[n]>0) n++;
            while(nums[p]<0) p++;

            if(i!=p) {
                int tmp=nums[p];
                int t2=p;
                while(t2> n) {
                    nums[t2]=nums[t2-1];
                    t2--;
                }
                nums[i] = tmp;

            }

            System.out.println(Arrays.toString(nums));
            if(i+1!=n) {
                int tmp=nums[n];
                int t2=n;
                while(t2> p) {
                    nums[t2]=nums[t2-1];
                    t2--;
                }
                nums[i+1]=tmp;
            }
            p++;
            n++;

            System.out.println(i);
            System.out.println(Arrays.toString(nums));

        }
        return nums;

    }

    public static void main(String[] args) {
        RearrangeArray ra = new RearrangeArray();
        System.out.println(Arrays.toString(ra.rearrangeArray(new int[]{3, 1, -2, -5, 2, -4})));
        System.out.println(Arrays.toString(ra.rearrangeArray(new int[]{-1, 1})));
//        Assert.assertEquals(new int[]{3, -2, 1, -5, 2, -4}, ra.rearrangeArray(new int[]{3, 1, -2, -5, 2, -4}));
    }
}
