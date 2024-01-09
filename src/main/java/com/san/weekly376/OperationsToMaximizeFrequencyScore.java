package com.san.weekly376;

import org.junit.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2968. Apply Operations to Maximize Frequency Score
 * User Accepted:413
 * User Tried:1318
 * Total Accepted:443
 * Total Submissions:2619
 * Difficulty:Hard
 * You are given a 0-indexed integer array nums and an integer k.
 *
 * You can perform the following operation on the array at most k times:
 *
 * Choose any index i from the array and increase or decrease nums[i] by 1.
 * The score of the final array is the frequency of the most frequent element in the array.
 *
 * Return the maximum score you can achieve.
 *
 * The frequency of an element is the number of occurences of that element in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,6,4], k = 3
 * Output: 3
 * Explanation: We can do the following operations on the array:
 * - Choose i = 0, and increase the value of nums[0] by 1. The resulting array is [2,2,6,4].
 * - Choose i = 3, and decrease the value of nums[3] by 1. The resulting array is [2,2,6,3].
 * - Choose i = 3, and decrease the value of nums[3] by 1. The resulting array is [2,2,6,2].
 * The element 2 is the most frequent in the final array so our score is 3.
 * It can be shown that we cannot achieve a better score.
 * Example 2:
 *
 * Input: nums = [1,4,4,2,4], k = 0
 * Output: 3
 * Explanation: We cannot apply any operations so our score will be the frequency of the most frequent element in the original array, which is 3.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 0 <= k <= 1014
 */
public class OperationsToMaximizeFrequencyScore {

    public int maxOccuringInArry(int[] nums) {
        Map<Integer, Integer> cntPerNum = new HashMap<>();
        int maxSeen=0;
        for(int i=0;i<nums.length;i++) {
            int curCnt = cntPerNum.getOrDefault(nums[i], 0);
            curCnt++;
            cntPerNum.put(nums[i], curCnt);
            if(maxSeen<curCnt){
                maxSeen = curCnt;
            }
        }
        return maxSeen;
    }

    /*public int maxFrequencyScore(int[] nums, long k) {
        if(k==0) {
            return maxOccuringInArry(nums);
        }
        Arrays.sort(nums);
        int[] diffs = new int[nums.length-1];
        for(int i=0;i<nums.length-1;i++) {
            diffs[i] = nums[i+1] - nums[i];
        }

        int maxFreq = 0;

        for(int i=0;i<nums.length;i++) {
            int leftAdd=0, rightAdd=0;
            int leftIdx=i-1, rightIdx=i+1;
            int expanstionCount=0, steps=0;
            while(steps<k && (leftIdx>=0 || rightIdx<diffs.length)) {
                int leftCost = Integer.MAX_VALUE;
                int rightCost = Integer.MAX_VALUE;

                if(leftIdx>=0) {
                    leftCost = leftAdd+diffs[leftIdx];
                }
                if(rightIdx<diffs.length) {
                    rightCost = rightAdd+diffs[rightIdx];
                }

                if(leftCost<rightCost && leftCost<=(k-steps)) {
                    steps+=leftAdd+diffs[leftIdx];
                    leftAdd+=diffs[leftIdx];
                    leftIdx--;
                    expanstionCount++;
                }else if(leftCost>rightCost && rightCost<=(k-steps)){
                    steps+=rightAdd+diffs[rightIdx];
                    rightAdd+=diffs[rightIdx];
                    rightIdx++;
                    expanstionCount++;
                }else {
                    steps= (int) k;
                }
            }
            if(expanstionCount>maxFreq) {
                maxFreq = expanstionCount;
            }
        }
        return maxFreq+1;
    }*/

    public int maxFrequencyScore(int[] nums, long k) {
        if(k==0) {
            return maxOccuringInArry(nums);
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        int maxFreq = 0;

        for(int i=0;i<nums.length;i++) {
            int leftIdx=i-1, rightIdx=i+1;
            int expanstionCount=1, steps=0;
            while(steps<k && (leftIdx>=0 || rightIdx<nums.length)) {
                int leftCost = Integer.MAX_VALUE;
                int rightCost = Integer.MAX_VALUE;

                if(leftIdx>=0) {
                    leftCost = Math.abs(nums[i]-nums[leftIdx]);
                }
                if(rightIdx<nums.length) {
                    rightCost = Math.abs(nums[i]-nums[rightIdx]);
                }

                if(leftCost<rightCost && leftCost<=(k-steps)) {
                    steps+=leftCost;
                    leftIdx--;
                    expanstionCount++;
                }else if(leftCost>rightCost && rightCost<=(k-steps)){
                    steps+=rightCost;
                    rightIdx++;
                    expanstionCount++;
                }else {
                    break;
                }
                System.out.println("InLoop %d expCount = %d with cost = %d".formatted(nums[i], expanstionCount, steps));
            }
            System.out.println("%d expCount = %d with cost = %d".formatted(nums[i], expanstionCount, steps));
            if(expanstionCount>maxFreq) {
                maxFreq = expanstionCount;
            }
        }
        return maxFreq;
    }

    public static void main(String[] args) {
        OperationsToMaximizeFrequencyScore otm = new OperationsToMaximizeFrequencyScore();
//        Assert.assertEquals(3, otm.maxFrequencyScore(new int[]{1, 2, 6, 4}, 3));
//        Assert.assertEquals(3, otm.maxFrequencyScore(new int[]{1,4,4,2,4}, 0));
//        Assert.assertEquals(10, otm.maxFrequencyScore(new int[]{3,20,13,2,3,15,24,19,8,13,19,20,21}, 45));
        Assert.assertEquals(14, otm.maxFrequencyScore(new int[]{13,22,29,21,13,17,5,2,27,6,10,4,23,29,27}, 117));
    }

}
