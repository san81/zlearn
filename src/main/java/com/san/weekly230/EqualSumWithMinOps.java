package com.san.weekly230;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 5691. Equal Sum Arrays With Minimum Number of Operations
 *
 * You are given two arrays of integers nums1 and nums2, possibly of different lengths. The values in the arrays are between 1 and 6, inclusive.
 *
 * In one operation, you can change any integer's value in any of the arrays to any value between 1 and 6, inclusive.
 *
 * Return the minimum number of operations required to make the sum of values in nums1 equal to the sum of values in nums2. Return -1​​​​​ if it is not possible to make the sum of the two arrays equal.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
 * Output: 3
 * Explanation: You can make the sums of nums1 and nums2 equal with 3 operations. All indices are 0-indexed.
 * - Change nums2[0] to 6. nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2].
 * - Change nums1[5] to 1. nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2].
 * - Change nums1[2] to 2. nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2].
 * Example 2:
 *
 * Input: nums1 = [1,1,1,1,1,1,1], nums2 = [6]
 * Output: -1
 * Explanation: There is no way to decrease the sum of nums1 or to increase the sum of nums2 to make them equal.
 * Example 3:
 *
 * Input: nums1 = [6,6], nums2 = [1]
 * Output: 3
 * Explanation: You can make the sums of nums1 and nums2 equal with 3 operations. All indices are 0-indexed.
 * - Change nums1[0] to 2. nums1 = [2,6], nums2 = [1].
 * - Change nums1[1] to 2. nums1 = [2,2], nums2 = [1].
 * - Change nums2[0] to 4. nums1 = [2,2], nums2 = [4].
 */
public class EqualSumWithMinOps {
    public int minOperations(int[] nums1, int[] nums2) {
        int maxLen = Math.max(nums1.length, nums2.length);
        int[] diffArr = new int[maxLen];
        Map<Integer, Integer> diffSum = new HashMap<>();
        int sumOfAllDiff = 0;
        for(int i=0;i<maxLen;i++){
            int fistVal=0, secondVal=0;
            if(i<nums1.length){
                fistVal = nums1[i];
            }
            if(i<nums2.length){
                secondVal = nums2[i];
            }
            int absDiff = Math.abs(fistVal - secondVal);
            sumOfAllDiff += absDiff;

        }

        int diffChecker = 5;
        int counter = 0;
        while(sumOfAllDiff>0) {
            int changes = sumOfAllDiff / diffChecker;
            sumOfAllDiff = sumOfAllDiff - (diffChecker * changes);
            counter += changes;
            diffChecker--;
        }
        return counter;
    }

    public static void main(String[] args) {
//        int[] nums1 = new int[]{1,2,3,4,5,6};
//        int[] nums2 = new int[]{1,1,2,2,2,2};

        int[] nums1 = new int[]{1,1,1,1,1,1,1};
        int[] nums2 = new int[]{6};

        System.out.println(new EqualSumWithMinOps().minOperations(nums1, nums2));
    }
}
