package com.san.weekly255;

import org.junit.Assert;

import java.util.*;

/**
 * 5852. Minimize the Difference Between Target and Chosen Elements
 * You are given an m x n integer matrix mat and an integer target.
 *
 * Choose one integer from each row in the matrix such that the absolute difference between target and the sum of the chosen elements is minimized.
 *
 * Return the minimum absolute difference.
 *
 * The absolute difference between two numbers a and b is the absolute value of a - b.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], target = 13
 * Output: 0
 * Explanation: One possible choice is to:
 * - Choose 1 from the first row.
 * - Choose 5 from the second row.
 * - Choose 7 from the third row.
 * The sum of the chosen elements is 13, which equals the target, so the absolute difference is 0.
 * Example 2:
 *
 *
 * Input: mat = [[1],[2],[3]], target = 100
 * Output: 94
 * Explanation: The best possible choice is to:
 * - Choose 1 from the first row.
 * - Choose 2 from the second row.
 * - Choose 3 from the third row.
 * The sum of the chosen elements is 6, and the absolute difference is 94.
 * Example 3:
 *
 *
 * Input: mat = [[1,2,9,8,7]], target = 6
 * Output: 1
 * Explanation: The best choice is to choose 7 from the first row.
 * The absolute difference is 1.
 */
public class MinimizeTargetAndChosenEleSum {


    public int minimizeTheDifference(int[][] mat, int target) {
        int minSumPossible = 0;
        for(int[] matRow:mat) {
            Arrays.sort(matRow);
            minSumPossible += matRow[0];
        }

        if(minSumPossible>target) {
            //it is not possible to minimize anymore.
            return Math.abs(minSumPossible-target);
        }

        Set<Integer> allSums = new HashSet<>();
        allSums.add(0);
        for(int i=0;i<mat.length;i++) {
            Set<Integer> additionalSums = new HashSet<>();
            for(int j=0;j<mat[i].length;j++){
                for(int x:allSums) {
                    additionalSums.add(mat[i][j]+x);
                }
            }
            allSums.addAll(additionalSums);

        }

        int minAns = Integer.MAX_VALUE;
        for(int i:allSums){
            if(Math.abs(minAns-target)>Math.abs(i-target)) minAns=i;
        }
        return Math.abs(minAns-target);
    }

    public static void main(String[] args) {
        MinimizeTargetAndChosenEleSum mtch = new MinimizeTargetAndChosenEleSum();
//        Assert.assertEquals(0,mtch.minimizeTheDifference(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 13));
//        Assert.assertEquals(94,mtch.minimizeTheDifference(new int[][]{{1}, {2}, {3}}, 100));
//        Assert.assertEquals(1,mtch.minimizeTheDifference(new int[][]{{1,2,9,8,7}}, 6));
//        Assert.assertEquals(32,mtch.minimizeTheDifference(new int[][]{{3, 5},{5, 10}}, 47));
        Assert.assertEquals(3,mtch.minimizeTheDifference(new int[][]{{10,3,7,7,9,6,9,8,9,5},{1,1,6,8,6,7,7,9,3,9},{3,4,4,1,3,6,3,3,9,9},{6,9,9,3,8,7,9,6,10,6}}, 5));
    }

}
