package com.san.weekly229;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 5687. Maximum Score from Performing Multiplication Operations
 *
 * Difficulty:Medium
 * You are given two integer arrays nums and multipliers of size n and m respectively, where n >= m. The arrays are 1-indexed.
 *
 * You begin with a score of 0. You want to perform exactly m operations. On the ith operation (1-indexed), you will:
 *
 * Choose one integer x from either the start or the end of the array nums.
 * Add multipliers[i] * x to your score.
 * Remove x from the array nums.
 * Return the maximum score after performing m operations.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3], multipliers = [3,2,1]
 * Output: 14
 * Explanation: An optimal solution is as follows:
 * - Choose from the end, [1,2,3], adding 3 * 3 = 9 to the score.
 * - Choose from the end, [1,2], adding 2 * 2 = 4 to the score.
 * - Choose from the end, [1], adding 1 * 1 = 1 to the score.
 * The total score is 9 + 4 + 1 = 14.
 * Example 2:
 *
 * Input: nums = [-5,-3,-3,-2,7,1], multipliers = [-10,-5,3,4,6]
 * Output: 102
 * Explanation: An optimal solution is as follows:
 * - Choose from the start, [-5,-3,-3,-2,7,1], adding -5 * -10 = 50 to the score.
 * - Choose from the start, [-3,-3,-2,7,1], adding -3 * -5 = 15 to the score.
 * - Choose from the start, [-3,-2,7,1], adding -3 * 3 = -9 to the score.
 * - Choose from the end, [-2,7,1], adding 1 * 4 = 4 to the score.
 * - Choose from the end, [-2,7], adding 7 * 6 = 42 to the score.
 * The total score is 50 + 15 - 9 + 4 + 42 = 102.
 */
public class MaxScoreFromPerformingMultiplicationOpr {

    int[] nums;
    int[] multipliers;
    Integer[][] mem ;

    public int maxRecursive(int start, int mIdx) {

        if(mIdx==multipliers.length) return 0;

        int end = nums.length - (mIdx-start)-1;
        if(mem[start][mIdx]!=null){
            return mem[start][mIdx];
        }

        int startSum = nums[start] * multipliers[mIdx]+ maxRecursive(start+1, mIdx+1);
        int endSum = nums[end] * multipliers[mIdx]+ maxRecursive(start,  mIdx+1);
        int maxValue = Math.max(startSum,endSum);
        mem[start][mIdx] = maxValue;
        return maxValue;
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        this.nums = nums;
        this.multipliers = multipliers;
        mem = new Integer[multipliers.length+1][multipliers.length+1];
        return maxRecursive(0, 0);
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3};
//        int[] multipliers = new int[]{3,2,1};

//        int[] nums = nums = new int[]{-5,-3,-3,-2,7,1};
//        int[] multipliers = new int[]{-10,-5,3,4,6};

        // expected 6861161
        int[] nums = new int[]{555,526,732,182,43,-537,-434,-233,-947,968,-250,-10,470,-867,-809,-987,120,607,-700,25,-349,-657,349,-75,-936,-473,615,691,-261,-517,-867,527,782,939,-465,12,988,-78,-990,504,-358,491,805,756,-218,513,-928,579,678,10};
        int[] multipliers = new int[]{783,911,820,37,466,-251,286,-74,-899,586,792,-643,-969,-267,121,-656,381,871,762,-355,721,753,-521};

        System.out.println(new MaxScoreFromPerformingMultiplicationOpr().maximumScore(nums, multipliers));
    }
}
